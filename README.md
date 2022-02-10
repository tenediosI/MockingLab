# MockingCardGameStart
## Setup
* See if not done from the last lab [https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/setup](https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/setup)
* Fork [MockingCardGameStart](https://stgit.dcs.gla.ac.uk/oose-2021-22-teaching-team/mockingcardgamestart.git) see [https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/Git/Project_Setup](https://stgit.dcs.gla.ac.uk/DerekSomerville/javagetstarted/-/wikis/home/Git/Project_Setup)
* Make sure you have invited Derek Somerville and your tutor as Developer Members


## Overview
* The lab will look at doubling using Mockito mock/spy. Please refer to week five lecture on Doubling and Mocking. This lab will mock calls to the file system, calls to external libraries and input from the console.
* Please find a video overview of what you need to know from the Doubling and Mocking lecture for the lab [https://uofglasgow.zoom.us/rec/share/tgSMJqDtXEKMVjLrVC3KerMROXc-pJdNkWz_PqhVQzgLlq6SZBAZQaVai-ShOvJK.R6N-RKi3I-uynYHR?startTime=1644483746000](https://uofglasgow.zoom.us/rec/share/tgSMJqDtXEKMVjLrVC3KerMROXc-pJdNkWz_PqhVQzgLlq6SZBAZQaVai-ShOvJK.R6N-RKi3I-uynYHR?startTime=1644483746000). Please see slides [https://gla.sharepoint.com/:f:/s/COMPSCI2008OBJECT-ORIENTEDSOFTWAREENGINEERING22/EqkJHUJO_1dOssa-Au6gvNUBl4iSNeniTN5QeLV1wL0xYw?e=Hr7IlR](https://gla.sharepoint.com/:f:/s/COMPSCI2008OBJECT-ORIENTEDSOFTWAREENGINEERING22/EqkJHUJO_1dOssa-Au6gvNUBl4iSNeniTN5QeLV1wL0xYw?e=Hr7IlR).

## Already Done
* Mocks have been completed for ConsoleInput, see [ConsoleInputTest](https://stgit.dcs.gla.ac.uk/oose-2021-22-teaching-team/mockingcardgamesolution/-/blob/main/src/test/java/Console/ConsoleInputTest.java). 
* You have also been provided with mocking for CardGame.getNumberOfPlayers in [CardGameTest](https://stgit.dcs.gla.ac.uk/oose-2021-22-teaching-team/mockingcardgamesolution/-/blob/main/src/test/java/Game/CardGameTest.java). 
* Please review these plus the lecture slides for Doubling and Mocking. 
* You have also had a worked example for mocking please see [https://stgit.dcs.gla.ac.uk/oose-2021-22-teaching-team/mockingrockpaperscissor](https://stgit.dcs.gla.ac.uk/oose-2021-22-teaching-team/mockingrockpaperscissor)
* This starter project uses "packages", please see Java Programming 2 [https://moodle.gla.ac.uk/pluginfile.php/4810902/mod_folder/content/0/1-packages.pdf?forcedownload=1](https://moodle.gla.ac.uk/pluginfile.php/4810902/mod_folder/content/0/1-packages.pdf?forcedownload=1)

## Game.CardGame Tests
* Aim to mock or spy at the earliest point so mock Scanner rather than ConsoleInput to maximise the code tested. If you mock external libraries you test more of your code.
* If you are mocking a class, look to see if there is a setter for the variable using this calls in the client class e.g. the main class the calls the class you mock.
* Create a test for getComputerPlayersNames, create a mock for LoadConfig, note there is CardGame.setLoadConfig.
  * Moderate - Test name getComputerPlayersNames you can get a list of at least three names. Use different names to the playersNames.cfg
* Create two tests for createComputerPlayers
  * Easy after previous - Test name createComputerPlayers for a list of three names and check the name of the third computer player is correct
  * Easy - Test name createComputerPlayersSize to see three players have been created
* Create a test for createHumanPlayer
  * Easy - Test name createHumanPlayer, check the name of the human player
* Create a test for initiatePlayers
  * Easy - Test name initiatePlayers, check the number of players created
* Create a test for play
  * Moderate - Test name play, think about the play while condition, try to run the game end to end

## Game.BlackJack
* Create a test for "play", so an end to end test 
  * Advanced - Test name is "play", check if the game has finished

## Structure.LoadConfig
* Create a test for populatePropertyData
  * Moderate - Test name populatePropertyData, check you can get at least two line mocked
* Create a test for getConfig
  * Easy with above test logic - Test name getConfig, same as above

## Submit
* Before you commit your final solution, double check it can build and all the test you completed can run.
* Go to the Week 6 section and open the assessment
* In text paste the https .git for the forked project
* Zip the project and submit