# Mastermind-CMPL

This is a small demo application to illustrate how to use
[CMPL](http://www.coliop.org/) with an application-generated model file.

This application implements the popular Mastermind board game. The game
will first create the "code" consisting of four "colors" (which are 1 to
6 in this implementation) and then allow for guesses. Each guess also
consists of four colors. If the guessed color is at the right position,
the result for the guess will contain a black pin. If the guessed color
is part of the "code" but not at the correct position the guess result
will contain a white pin. If the "code" does not contain the guessed
color no pin will be output.

Using the guess output from the Mastermind board, the application
auto-generates a CMPL model. This is then solved using the CMPL CBC
solver to generate the next guess. From my tests, the solver has always
been able to guess the correct solution within the maximum allowed
12 tries.

## Setup

Make sure the application can write to the *etc* subdirectory of the
application directory. It needs to store generated CMPL files there to
pass to the CMPL CBC solver in order to get a new guess.

Install the CMPL package on your machine and make sure it is in the
path.

Compile and run the application.
