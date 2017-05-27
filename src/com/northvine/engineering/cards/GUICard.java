package com.northvine.engineering.cards;

import javax.swing.*;

/**
 * This class is the benefactor of most of the GUI machinery we tested in Phase 1.
 * It will read the image files and store them in a static Icon array. Rather than a 1-D
 * array of Phase 1, this will be a 2-D array to facilitate addressing the value and suit
 * of a Card in order get its Icon. While simple in principle (just read the Icons and store
 * them in an array for client use), the details are subtle. We have to be able to convert from chars
 * and suits to ints, and back again, in order to find the Icon for any given Card object. The overview
 * of the class data and methods, shown below, will suggest the right approach and should take the
 * mystery out of this class.
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 26th, 2017
 * @Version 1.0.0
 */
public class GUICard
{
   private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
   private static Icon iconBack; // Single Image for all card backs
   private static boolean iconsLoaded = false; // Loading Flag

   /**
    * Public Static Accessor Method
    *
    * This accessor method returns appropriate card
    * face matching the argument card in the form of
    * a javax.swing.Icon
    *
    * @param card this argument represents the card in
    *             of which the returned Icon is intended
    *             to represent as an image
    * @return Icon representing argument card face
    */
   public static Icon getIcon(final Card card)
   {
      if(!iconsLoaded) // no need to load more than once
      {
         loadCardIcons();
      }
      return iconCards[new String(Card.LEGAL_VALUES).indexOf(card.getValue())][card.getSuit().intValue];
   }

   /**
    * Public Static Accessor Method
    *
    * This accessor method returns the image of the card
    * back in the form of a javax.swing.Icon
    * @return Icon representing the back of a card
    */
   public static Icon getBackCardIcon()
   {
      if(!iconsLoaded) // no need to load more than once
      {
         loadCardIcons();
      }
      return iconBack;
   }

   /*
      Private Helper Method

      This method will load all the card faces and card back from
      the assets/images directory underneath the directory marked by the
      system variable "user.dir". This method ensures that the images
      act as singletons by only loading the images once.
    */
   private static void loadCardIcons()
   {
      if(!iconsLoaded) // Only load images once
      {
         final String IMAGES_DIR = String.format("%s/%s/", System.getProperty("user.dir"), "assets/images");

         for(int suitIndex = 0; suitIndex < Card.Suit.NUM_SUITS; suitIndex++)
         {
            for(int valueIndex = 0; valueIndex < Card.LEGAL_VALUES.length; valueIndex++)
            {
               iconCards[valueIndex][suitIndex] = new ImageIcon(String.format("%s%s%s.gif", IMAGES_DIR, Card.LEGAL_VALUES[valueIndex], Card.Suit.valueOf(suitIndex)));
            }
         }
         iconBack = new ImageIcon(String.format("%s%s.gif", IMAGES_DIR, "BK")); //sets cards back image
         iconsLoaded = true;
      }
   }
}