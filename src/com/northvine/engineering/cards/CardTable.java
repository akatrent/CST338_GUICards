package com.northvine.engineering.cards;

import javax.swing.*;

/**
 * The second part creates a separate CardTable class that extends JFrame.
 * This class will control the positioning of the panels and cards of the GUI.
 * We also create a new GUICard class that manages the reading and building of the card image Icons.
 * As a result, some of the machinery and statics that we debugged in the first phase of the main
 * will be moved into one or the other of these two new classes.
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 24th, 2017
 * @Version 1.0.0
 */
public class CardTable extends JFrame
{
   final static int MAX_CARDS_PER_HAND = 56;
   final static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games

   private int numCardsPerHand;
   private int numPlayers;

   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;

   public CardTable(String title, int numCardsPerHand, int numPlayers)
   {

   }

}
