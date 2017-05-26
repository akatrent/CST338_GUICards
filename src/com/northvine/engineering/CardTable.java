package com.northvine.engineering;

import javax.swing.*;

/**
 * Created by trammelmay on 5/25/17.
 */
public class CardTable extends JFrame
{
   private static int MAX_CARDS_PER_HAND = 56;
   private static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games

   private int numCardsPerHand;
   private int numPlayers;

   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;

   public CardTable(final String title, int numCardsPerHand, int numPlayers)
   {
      this.numPlayers = numPlayers;
      this.numCardsPerHand = numCardsPerHand;
      this.setTitle(title);
   }

   public int getNumCardsPerHand()
   {
      return numCardsPerHand;
   }

   public int getNumPlayers()
   {
      return numPlayers;
   }
}
