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
 * @Date May 24th, 2017
 * @Version 1.0.0
 */

public class GUICard
{
   private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
   private static Icon iconBack;
   static boolean iconsLoaded = false;

   private static void loadCardIcons()
   {

   }

   public static Icon getIcon(Card card)
   {

   }

   public static Icon getBackCardIcon()
   {

   }
}
