package com.shyrokykh.subtask2.runner;

import com.shyrokykh.subtask2.entity.Carriage;
import com.shyrokykh.subtask2.entity.Train;
import com.shyrokykh.subtask2.presenter.util.ResultViewer;
import com.shyrokykh.subtask2.runner.enums.CarriageTypes;
import com.shyrokykh.subtask2.runner.enums.MenuCommands;
import com.shyrokykh.subtask2.runner.exception.IllegalCarriageTypeException;
import com.shyrokykh.subtask2.runner.exception.IllegalMenuItemException;
import com.shyrokykh.subtask2.runner.exception.constant.Messages;
import com.shyrokykh.subtask2.util.CarriageComparators;
import com.shyrokykh.subtask2.util.CarriageFactory;
import com.shyrokykh.subtask2.util.TrainInformationDesk;
import com.shyrokykh.subtask2.util.UserInput;
import com.shyrokykh.subtask2.util.exception.IllegalHighPassengerCapacityBoundaryException;
import com.shyrokykh.subtask2.util.exception.IllegalLowPassengerCapacityBoundaryException;

import java.util.HashMap;
import java.util.Map;

public final class Runner {
    private static final Map<CarriageTypes, Factory> CARRIAGE_FACTORIES = new HashMap<CarriageTypes, Factory>() {{
        put(CarriageTypes.COMPARTMENT, CarriageFactory::createCompartmentCarriage);
        put(CarriageTypes.ECONOM, CarriageFactory::createEconomClassCarriage);
        put(CarriageTypes.FIRST, CarriageFactory::createFirstClassCarriage);
        put(CarriageTypes.LUXURY, CarriageFactory::createLuxuryCarriage);
    }};

    private Runner() {}

    private static void printMenu() {
        for (MenuCommands command : MenuCommands.values()) {
            System.out.println(String.format("%d) %s", (command.ordinal() + 1), command.getDescription()));
        }
    }

    private static MenuCommands selectMenuItem() throws IllegalMenuItemException {
        int menuItemPos = -1;

        try {
            ResultViewer.printMessage(com.shyrokykh.subtask2.runner.constant.Messages.SELECT_MENU_ITEM);
            menuItemPos = UserInput.readInt();

            return MenuCommands.values()[menuItemPos - 1];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalMenuItemException(String.format("%s: %d", Messages.ERR_ILLEGAL_MENU_ITEM, menuItemPos));
        }
    }

    private static void printCarriageTypes() {
        for (CarriageTypes type : CarriageTypes.values()) {
            System.out.println(String.format("%d) %s", (type.ordinal() + 1), type.getDescription()));
        }
    }

    private static Carriage createCarriage(CarriageTypes type) {
        ResultViewer.printMessage(com.shyrokykh.subtask2.runner.constant.Messages.ENTER_PASS_CAPACITY);
        int passengerCapacity = UserInput.readInt();

        ResultViewer.printMessage(com.shyrokykh.subtask2.runner.constant.Messages.ENTER_BAGGAGE_CAPACITY);
        int baggageCapacity = UserInput.readInt();

        return CARRIAGE_FACTORIES.get(type).createCarriage(passengerCapacity, baggageCapacity);
    }

    private static void addCarriage(Train<Carriage> train) throws IllegalCarriageTypeException {
        printCarriageTypes();

        int carriageTypePos = -1;

        try {
            carriageTypePos = UserInput.readInt();

            train.addCarriage(createCarriage(CarriageTypes.values()[carriageTypePos - 1]));
            ResultViewer.printMessage(com.shyrokykh.subtask2.runner.constant.Messages.ADDED_NEW_CARRIAGE);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalCarriageTypeException(String.format("%s: %d",
                    Messages.ERR_ILLEGAL_CARRIAGE_TYPE, carriageTypePos));
        }
    }

    private static void findCarriagesWithPassengerCapacityInRange(Train<Carriage> train) {
        ResultViewer.printMessage(com.shyrokykh.subtask2.runner.constant.Messages.ENTER_LOW_BOUNDARY_OF_PASS_CAP);
        int from = UserInput.readInt();

        ResultViewer.printMessage(com.shyrokykh.subtask2.runner.constant.Messages.ENTER_HIGH_BOUNDARY_OF_PASS_CAP);
        int to = UserInput.readInt();

        try {
            ResultViewer.printMessage(TrainInformationDesk.getCarriagesWithPassengerCapacityInRange(train, from, to));
        } catch (IllegalLowPassengerCapacityBoundaryException | IllegalHighPassengerCapacityBoundaryException e) {
            ResultViewer.printError(e.getMessage());
        }
    }

    private static void performMenuCommand(MenuCommands selectedCommand, Train<Carriage> train)
            throws IllegalCarriageTypeException {
        switch (selectedCommand) {
            case ADD_CARRIAGE:
                addCarriage(train);
                break;
            case SORT_CARRIAGES:
                ResultViewer.printMessage(TrainInformationDesk.sort(train,
                        CarriageComparators.comfortComparator())
                );
                break;
            case CALC_TOTAL_PASS_CAP:
                ResultViewer.printMessage(
                        String.valueOf(TrainInformationDesk.calcTotalNumberOfBaggageAndPassengers(train))
                );
                break;
            case FIND_CARRIAGES_WITH_PASS_CAP_IN_RANGE:
                findCarriagesWithPassengerCapacityInRange(train);
                break;
        }
    }

    public static void run() {
        final Train<Carriage> train = new Train<>();
        MenuCommands selectedCommand;

        do {
            printMenu();

            try {
                selectedCommand = selectMenuItem();

                if (selectedCommand == MenuCommands.EXIT) {
                    break;
                } else {
                    performMenuCommand(selectedCommand, train);
                }
            } catch (Exception e) {
                ResultViewer.printError(e.getMessage());
            }
        } while (true);
    }
}
