package calculadora;

import java.lang.Math;
import javax.swing.JOptionPane;

public class Main {
    public static void main ( String[] args ) {
        int option;
        boolean condition = true;

        while ( condition ) {
            try {
                option = Integer.parseInt ( JOptionPane.showInputDialog ( """
                        WELCOME TO THE CODE CHALLENGE TOPIC 0 :)
                        1- CALCULATOR
                        2- TRIGONOMETRIC FUNCTIONS
                        3- CONVERTER (USD - COP)
                        4- EXIT""" ) );

                switch ( option ) {
                    case 1 -> runCalculator ();
                    case 2 -> runTrigonometricFunctions ();
                    case 3 -> runConverter ();
                    case 4 -> {
                        condition = false;
                        JOptionPane.showMessageDialog ( null , "YOU LEFT THE SYSTEM :)" );
                    }
                    default -> showErrorMessage ( "INVALID NUMBER" );
                }
            } catch ( NumberFormatException e ) {
                showErrorMessage ( "INVALID CHARACTER. PLEASE ENTER A NUMBER." );
            }
        }
    }

    public static void runCalculator () {
        boolean condition = true;

        while ( condition ) {
            try {
                int option = Integer.parseInt ( JOptionPane.showInputDialog ( """
                        ENTER THE OPTION TO PERFORM
                        1- SUM
                        2- SUBTRACT
                        3- MULTIPLICATION
                        4- DIVIDE
                        5- EXIT""" ) );

                switch ( option ) {
                    case 1 -> performOperation ( Operation.SUM );
                    case 2 -> performOperation ( Operation.SUBTRACT );
                    case 3 -> performOperation ( Operation.MULTIPLICATION );
                    case 4 -> performOperation ( Operation.DIVIDE );
                    case 5 -> {
                        condition = false;
                        JOptionPane.showMessageDialog ( null , "YOU LEFT THE CALCULATOR :)" );
                    }
                    default -> showErrorMessage ( "INVALID NUMBER" );
                }
            } catch ( NumberFormatException e ) {
                showErrorMessage ( "INVALID CHARACTER. PLEASE ENTER A NUMBER." );
            }
        }
    }

    public static void runTrigonometricFunctions () {
        boolean condition = true;

        while ( condition ) {
            try {
                int option = Integer.parseInt ( JOptionPane.showInputDialog ( """
                        TRIGONOMETRIC FUNCTIONS
                        1- ARCSINE
                        2- ARCCOSINE
                        3- ARCTANGENT
                        4- EXIT""" ) );

                switch ( option ) {
                    case 1 -> calculateArcsine ();
                    case 2 -> calculateArccosine ();
                    case 3 -> calculateArctangent ();
                    case 4 -> {
                        condition = false;
                        JOptionPane.showMessageDialog ( null , "YOU LEFT THE TRIGONOMETRIC FUNCTIONS :)" );
                    }
                    default -> showErrorMessage ( "INVALID NUMBER" );
                }
            } catch ( NumberFormatException e ) {
                showErrorMessage ( "INVALID CHARACTER. PLEASE ENTER A NUMBER." );
            }
        }
    }

    public static void runConverter () {
        double dollars = getNumber ( "ENTER DOLLAR AMOUNT:" );
        double exchangeRate = 3000;
        double cop = dollars * exchangeRate;
        JOptionPane.showMessageDialog ( null , dollars + " DOLLARS IS EQUIVALENT TO " + cop + " COLOMBIAN PESOS " );
    }

    public static double getNumber ( String message ) {
        double number;
        while ( true ) {
            try {
                number = Double.parseDouble ( JOptionPane.showInputDialog ( message ) );
                break;
            } catch ( NumberFormatException e ) {
                showErrorMessage ( "INVALID CHARACTER. PLEASE ENTER A NUMBER." );
            } catch ( NullPointerException e ) {
                System.exit ( 0 );
            }
        }
        return number;
    }

    public static void performOperation ( Operation operation ) {
        double numberOne = getNumber ( "ENTER A NUMBER #1" );
        double numberTwo = getNumber ( "ENTER A NUMBER #2" );
        double result = 0;

        switch ( operation ) {
            case SUM -> result = numberOne + numberTwo;
            case SUBTRACT -> result = numberOne - numberTwo;
            case MULTIPLICATION -> result = numberOne * numberTwo;
            case DIVIDE -> {
                if ( numberTwo != 0 ) {
                    result = numberOne / numberTwo;
                } else {
                    showErrorMessage ( "CANNOT BE DIVIDED INTO 0" );
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog ( null , "THE RESULT IS: " + result );
    }

    public static void calculateArcsine () {
        double inputValue = getNumber ( "ENTER A VALUE BETWEEN -1 AND 1 TO CALCULATE ARCSINE:" );
        if ( inputValue >= -1 && inputValue <= 1 ) {
            double arcsine = Math.asin ( inputValue );
            double arcsineDegrees = Math.toDegrees ( arcsine );
            showMessage ( "ARCSINE OF " + inputValue + " IN RADIANS: " + arcsine +
                    "\nARCSINE OF " + inputValue + " IN DEGREES: " + arcsineDegrees );
        } else {
            showErrorMessage ( "THE VALUE MUST BE IN THE RANGE [-1, 1]." );
        }
    }

    public static void calculateArccosine () {
        double inputValue = getNumber ( "ENTER A VALUE BETWEEN -1 AND 1 TO CALCULATE ARCCOSINE:" );
        if ( inputValue >= -1 && inputValue <= 1 ) {
            double arccosine = Math.acos ( inputValue );
            double arccosineDegrees = Math.toDegrees ( arccosine );
            showMessage ( "ARCCOSINE OF " + inputValue + " IN RADIANS: " + arccosine +
                    "\nARCCOSINE OF " + inputValue + " IN DEGREES: " + arccosineDegrees );
        } else {
            showErrorMessage ( "THE VALUE MUST BE IN THE RANGE [-1, 1]." );
        }
    }

    public static void calculateArctangent () {
        double inputValue = getNumber ( "ENTER A VALUE TO CALCULATE ARCTANGENT:" );
        double arctangent = Math.atan ( inputValue );
        double arctangentDegrees = Math.toDegrees ( arctangent );
        showMessage ( "ARCTANGENT OF " + inputValue + " IN RADIANS: " + arctangent +
                "\nARCTANGENT OF " + inputValue + " IN DEGREES: " + arctangentDegrees );
    }

    public static void showErrorMessage ( String message ) {
        JOptionPane.showMessageDialog ( null , message );
    }

    public static void showMessage ( String message ) {
        JOptionPane.showMessageDialog ( null , message );
    }

    public enum Operation {
        SUM,
        SUBTRACT,
        MULTIPLICATION,
        DIVIDE
    }
}

