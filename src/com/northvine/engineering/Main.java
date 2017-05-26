package com.northvine.engineering;

import javax.swing.*;
import java.awt.*;

/**
 *  This class is the main class for Phase1 of the assignment
 *  All this class does is loads up the cards images and displays them
 *  as JLabels
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 24th, 2017
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
      // code goes here ...

      // ADD LABELS TO PANELS -----------------------------------------
      //code goes here ...

      // and two random cards in the play region (simulating a computer/hum ply)
      //code goes here ...

      // show everything to the user
      myCardTable.setVisible(true);
   }
}