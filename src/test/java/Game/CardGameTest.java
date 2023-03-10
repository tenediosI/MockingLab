package Game;

import Console.ConsoleInput;
import Game.CardGame;
import Structure.Hand;
import Structure.LoadConfig;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class CardGameTest {
    CardGame cardGame = new CardGame();
    @Test
    void getDeck() {
        assertEquals(52, cardGame.getDeck().size());
    }

    @Test
    void cardGameOverride(){
        CardGame overrideCardGame = new CardGame("H3,H4,H5,D6");
        assertEquals(4, overrideCardGame.getDeck().size());
    }

    @Test
    void dealCards() {
        CardGame cardGame = new CardGame("D3,D2,S5,S6");
        Hand hand = new Hand();
        hand = cardGame.dealHand(hand, 3);
        assertEquals("S6, S5, D2", hand.toString());
    }

    @Test
    void outputOne(){
        cardGame.output("Test One");
        assertEquals("Test One", cardGame.userOutput.getStoreOutput().get(0));
    }

    @Test
    void outputTwo(){
        cardGame.output("Test One");
        cardGame.output("Test Two");
        assertEquals("Test Two", cardGame.userOutput.getStoreOutput().get(1));
    }

    @Test
    void outputTwoCount(){
        cardGame.output("Test One");
        cardGame.output("Test Two");
        assertEquals(2, cardGame.userOutput.getStoreOutput().size());
    }


    @Test
    void getNumberOfPlayers(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("3");
        cardGame.userInput.setUserInput(mockScanner);
        assertEquals(3, cardGame.getNumberOfPlayers());
    }

    @Test
    void getInteger(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("3");
        cardGame.userInput.setUserInput(mockScanner);
        assertEquals(3, cardGame.getInteger());
    }

    @Test
    void getIntegerFirstString(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("one");
        when(mockScanner.nextLine()).thenReturn("25");
        cardGame.userInput.setUserInput(mockScanner);
        assertEquals(25, cardGame.getInteger());
    }

    @Test
    void getString(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("yes");
        cardGame.userInput.setUserInput(mockScanner);
        assertEquals("yes", cardGame.getString());
    }

    @Test
    void getComputerPlayersNames(){
    	List<String> namesList = new ArrayList<String>();
    	namesList.add("Rob");
    	namesList.add("Bob");
    	namesList.add("Andrew");
    	namesList.add("Paul");
        LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(namesList);
        cardGame.setLoadConfig(mockLoadConfig);
        assertEquals(namesList,cardGame.getComputerPlayersNames());
    }

    @Test
    void createComputerPlayers(){
    	List<String> namesList = new ArrayList<String>();
    	namesList.add("Rob");
    	namesList.add("Bob");
    	namesList.add("Andrew");
    	namesList.add("Paul");
    	LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(namesList);
        cardGame.setLoadConfig(mockLoadConfig);
        cardGame.createComputerPlayers(4);
        assertEquals("Andrew",cardGame.players.get(2).getName());
    }

    @Test
    void createComputerPlayersSize(){
    	List<String> namesList = new ArrayList<String>();
    	namesList.add("Rob");
    	namesList.add("Bob");
    	namesList.add("Andrew");
    	namesList.add("Paul");
    	LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(namesList);
        cardGame.setLoadConfig(mockLoadConfig);
        cardGame.createComputerPlayers(4);
        assertEquals(4,cardGame.getNumberOfPlayers());
    }

    @Test
    void createHumanPlayer(){
        ConsoleInput mockConsoleInput = mock(ConsoleInput.class);
        when(mockConsoleInput.getString()).thenReturn("Rob");
        cardGame.setUserInput(mockConsoleInput);
        cardGame.createHumanPlayer();
        assertEquals("Rob",cardGame.players.get(0).getName());
    }

    @Test
    void initiatePlayers(){
    	List<String> namesList = new ArrayList<String>();
    	namesList.add("Rob");
    	namesList.add("Bob");
    	namesList.add("Andrew");
    	namesList.add("Paul");
    	LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(namesList);
        ConsoleInput mockConsoleInput = mock(ConsoleInput.class);
        when(mockConsoleInput.getString()).thenReturn("Andrew");
        when(mockConsoleInput.getInteger()).thenReturn(5);
        cardGame.setLoadConfig(mockLoadConfig);
        cardGame.setUserInput(mockConsoleInput);
        cardGame.initiate();
        assertEquals(5,cardGame.players.size());
    }

    @Test
    void initiate(){
    	List<String> namesList = new ArrayList<String>();
    	namesList.add("Rob");
    	namesList.add("Bob");
    	namesList.add("Andrew");
    	namesList.add("Paul");
    	LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(namesList);
        ConsoleInput mockConsoleInput = mock(ConsoleInput.class);
        when(mockConsoleInput.getString()).thenReturn("Andrew");
        when(mockConsoleInput.getInteger()).thenReturn(5);
        cardGame.setLoadConfig(mockLoadConfig);
        cardGame.setUserInput(mockConsoleInput);
        cardGame.initiate();
        assertEquals(true,cardGame.players.get(2).hasHand());
    }

    @Test
    void play(){
    	List<String> namesList = new ArrayList<String>();
    	namesList.add("Rob");
    	namesList.add("Bob");
    	namesList.add("Andrew");
    	namesList.add("Paul");
    	LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(namesList);
        ConsoleInput mockConsoleInput = mock(ConsoleInput.class);
        when(mockConsoleInput.getString()).thenReturn("Andrew");
        when(mockConsoleInput.getInteger()).thenReturn(5);
        cardGame.setLoadConfig(mockLoadConfig);
        cardGame.setUserInput(mockConsoleInput);
        cardGame.setFinishGame(true);
        cardGame.play();
        assertEquals(true,cardGame.finshGame);
    }

}