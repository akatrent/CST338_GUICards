package com.northvine.engineering.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * The CardTable class represents the Game Screen in which
 * the end users will interact with.
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 26th, 2017
 * @Version 1.0.0
 */
public class CardTable extends JFrame
{
   private static final int MAX_CARDS_PER_HAND = 56; // Max number of cards per hand
   private static final int MAX_PLAYERS = 2;  // for now, we only allow 2 person games

   private int numCardsPerHand; // Number of Cards per hand
   private int numPlayers;

   // JPanel objects representing the three sections of the Frame
   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;

   /**
    * Public Parameterized Constructor
    *
    * This constructor initializes three JPanels with borders and titles.
    *
    * @param title this represents the string used as the title for the JFrame
    * @param numCardsPerHand this represents the allowed number of cards per hand.
    *                        this number cannot exceed MAX_CARDS_PER_HAND or it will
    *                        be set to MAX_CARDS_PER_HAND. It also must be greater than
    *                        0 or it will be set to 7.
    * @param numPlayers this represents the number of players in the game. The number
    *                   cannot exceed MAX_PLAYERS or it will be set to MAX_PLAYERS. It
    *                   also cannot be less than or equal to 0 or it will be set to 1.
    */
   public CardTable(final String title, int numCardsPerHand, int numPlayers)
   {
      initDataMembers(numCardsPerHand, numPlayers);
      initFrame(title);
      initPanels();
   }

   /**
    * Public Accessor Method
    *
    * This method simply returns the number of cards allowed per hand.
    * @return integer value representing the number of cards allowed
    *         per hand. This value can only be set in the constructor
    *         and cannot exceed the MAX_CARDS_PER_HAND defined locally.
    *         This value also cannot be less than or equal to 1.
    */
   public int getNumCardsPerHand()
   {
      return numCardsPerHand;
   }

   /**
    * Public Accessor Method
    *
    * This method simply retruns the number of cards allowed per hand.
    * @return integer value representing the number of players in the
    *         game. This value can only be set in the constructor
    *         and cannot exceed the MAX_PLAYERS defined locally.
    *         This value also cannot be less than or equal to 1.
    */
   public int getNumPlayers()
   {
      return numPlayers;
   }

   /*
      Private Helper Method - Mutator

      This method validates the integer arguments such that
      they do not exceed the limits defined by the MAX_CARDS_PER_HAND
      and MAX_PLAYERS data members, nor equate to values less than or
      equal to 0. If exceeded, these values will be set to their limits,
      and if not meeting the minimums, they will be set to
      7 cards in the hand and 1 player.

      @param numCardsPerHand this represents the desired number
                             of cards allowed per hand
      @param numPlayers this represents the desired number of
                        players at the table.
    */
   private void initDataMembers(int numCardsPerHand, int numPlayers)
   {
      // TODO I am not sure if these validations are correct, please check
      if(numCardsPerHand < 0)
      {
         numCardsPerHand = 7;
      }
      if(numPlayers <= 0)
      {
         numPlayers = 1;
      }
      this.numPlayers = numPlayers > MAX_PLAYERS ? MAX_PLAYERS : numPlayers;
      this.numCardsPerHand = numCardsPerHand > MAX_CARDS_PER_HAND ? MAX_CARDS_PER_HAND : numCardsPerHand;
   }

   /*
      Private Helper Method - Mutator

      This method sets up the JFrame object with a FlowLayout, Title,
      and default closed operations.

     @param title this string represents the desired JFrame title
    */
   private void initFrame(final String title)
   {
      final BorderLayout layout = new BorderLayout();
      setLayout(layout);
      setTitle(title);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }

   /*
      Private Helper Method - Mutator

      This method initializes the three public data JPanel data members
      with their respective titles and positions.
    */
   private void initPanels()
   {
      setupPanel(pnlComputerHand = new JPanel(), "Computer Hand", 0, 0);
      add(pnlComputerHand, BorderLayout.NORTH);
      setupPanel(pnlPlayArea = new JPanel(), "Playing Area", 0, pnlComputerHand.getHeight());
      pnlPlayArea.setLayout(new GridLayout(1, 2));
      add(pnlPlayArea, BorderLayout.CENTER);
      setupPanel(pnlHumanHand = new JPanel(), "Your Hand", 0, pnlComputerHand.getHeight() + pnlPlayArea.getHeight());
      add(pnlHumanHand, BorderLayout.SOUTH);
   }

   /*
     Private Helper Method - Mutator

     This method will set up the argument JPanel with the argument title
     and x y coordinates. A TitledBorder will be applied to the JPanel
     and it will be set to enabled and visible.

     @param panel this represents the JPanel object to be setup
     @param title this represents the desired JPanel title
     @param x this represents the desired JPanel X position
     @param y this represents the desired JPanel Y position
    */
   private void setupPanel(final JPanel panel, final String title, int x, int y)
   {
      // Create Title Border With Title at top left
      final TitledBorder border = new TitledBorder(title);
      border.setTitleJustification(TitledBorder.LEFT);
      border.setTitlePosition(TitledBorder.TOP);

      // Initialize JPanel
      panel.setBorder(border);
      panel.setLocation(x, y);
      panel.setEnabled(true);
      panel.setVisible(true);
   }
}
