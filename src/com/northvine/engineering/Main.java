package com.northvine.engineering;

import com.northvine.engineering.cards.Card;
import com.northvine.engineering.cards.Deck;
import com.northvine.engineering.gui.GUICard;
import com.northvine.engineering.gui.CardTable;

import javax.swing.*;

/**
 *  This class is the main class for Phase 2 of the assignment
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 26th, 2017
 * @Version 1.0.0
 */
public class Main
{
   private static int NUM_CARDS_PER_HAND = 7;
   private static int NUM_PLAYERS = 2;
   private static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   private static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];
   private static JLabel[] playedCardLabels = new JLabel[NUM_PLAYERS];
   private static JLabel[] playLabelText = new JLabel[NUM_PLAYERS];

   public static void main(String[] args)
   {
      int k;
      Icon tempIcon;

      // establish main frame in which program will run
      CardTable myCardTable = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // show everything to the user
      myCardTable.setVisible(true);

      // CREATE LABELS ----------------------------------------------------
      final Deck deck = new Deck();

      for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
      {
         humanLabels[i] = new JLabel(GUICard.getIcon(deck.dealCard()));
         computerLabels[i] = new JLabel(GUICard.getBackCardIcon());
      }

      // ADD LABELS TO PANELS -----------------------------------------
      for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
      {
         myCardTable.pnlHumanHand.add(humanLabels[i]);
         myCardTable.pnlComputerHand.add(computerLabels[i]);
      }

      // and two random cards in the play region (simulating a computer/hum ply)
      JLabel computersCard = new JLabel("Computer", JLabel.CENTER);
      computersCard.setIcon(GUICard.getIcon(generateRandomCard()));
      computersCard.setVerticalTextPosition(JLabel.BOTTOM);
      computersCard.setHorizontalTextPosition(JLabel.CENTER);

      JLabel playersCard = new JLabel("Computer", JLabel.CENTER);
      playersCard.setIcon(GUICard.getIcon(generateRandomCard()));
      playersCard.setVerticalTextPosition(JLabel.BOTTOM);
      playersCard.setHorizontalTextPosition(JLabel.CENTER);
      
      myCardTable.pnlPlayArea.add(computersCard);
      myCardTable.pnlPlayArea.add(playersCard);

      // show everything to the user
      myCardTable.setVisible(true);
   }

   private static Card generateRandomCard()
   {
      final Deck deck = new Deck();
      deck.shuffle();
      return deck.dealCard();
   }
}
