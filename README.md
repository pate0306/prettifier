# prettifier

## Approach
- Determine the data type to store the numeric input keeping in mind the maximum supported decimal number (trillion as stated in the problem description)
- Figure out the logic to understand how big the number is and the suffix to be added
- Implement a number formatter to round decimal digits
- Perform some initial tests to ensure validility
- Organize the code to separate responsibilities amongst different classes. Make the prettifier more extensible by exposing an interface and making the prettifier implement it
- Create a runner class that instantiates the prettifier, gets an input and prints the prettified output

## Assumptions
- As the maximum supported input is in trillions, I decided to use float which satisfies the required range.
- There was no mention of support for prettifying negative number inputs. Thus, the logic is implemented to process only positive numbers.
- Decimal numbers less than a million should also be round to a single digit of precision
- When rounding, the digit after the decimal point should be incremented by 1 if the following digit is greater than 5

## Design Decisions
- Float data type is used to store and process the out as I thought it satisfies the given requirements. In order to support bigger numbers, double or BigDecimal can be used
- Created a NumberPrettifier interface with a single method declaration as of now. This was done so that different kinds of prettifiers can be created implementing the interface
- Added a runner to get input from the user and test the prettier
