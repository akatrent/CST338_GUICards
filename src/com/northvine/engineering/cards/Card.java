package com.northvine.engineering.cards;

/**
 * The Card class is a data structure for storing information representing an
 * individual card that may be contained within a Hand or a Deck.
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 10th, 2017
 * @Version 1.0.0
 */
public class Card
{
   //Public enum Members:
   public enum Suit
   {
      CLUBS(0, 'C'), DIAMONDS(1, 'D'), HEARTS(2, 'H'), SPADES(3, 'S');

      public static final int NUM_SUITS = 4;
      public int intValue;
      public char charValue;

      Suit(int intValue, char charValue)
      {
         this.intValue = intValue;
         this.charValue = charValue;
      }

      public static Suit valueOf(int integer)
      {
         for(Suit suit : Suit.values())
         {
            if(integer == suit.intValue)
            {
               return suit;
            }
         }
         return null;
      }
   };

   //Public Static Data Members:
   public static final char[] LEGAL_VALUES = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'X'};
   public static char[] valueRanks = LEGAL_VALUES;

   //Private Data Members:
   private char value;
   private boolean errorFlag = false;
   private Suit cardSuit = null;

   /**
    * Public Default Constructor Initializes value to 'A' and Suit to spades
    */
   public Card()
   {
      set('A', Suit.SPADES);
   }

   /**
    * Public Constructor
    *
    * @param newValue
    *           card value to be stored
    * @param newSuit
    *           card suit to be stored
    */
   public Card(char newValue, final Suit newSuit)
   {
      set(newValue, newSuit);
   }

   /**
    * Public Copy Constructor
    *
    * @param originalCard
    *           values to be copied into new separate
    *           Card object
    */
   public Card(final Card originalCard)
   {
      value = originalCard.value;
      cardSuit = originalCard.cardSuit;
      errorFlag = originalCard.errorFlag;
   }

   /**
    * Public Accessor Method This is the overridden toString method
    *
    * @return String object of concatenated value and suite of
    *         Card object returns ** illegal **
    *         if errorFlag is true
    */
   @Override
   public String toString()
   {
      return errorFlag ? "** illegal **" : String.format("%s of %s", value, cardSuit);
   }

   /**
    * Public Accessor Method
    *
    * @param compareCard
    *           card to be compared
    * @return true if all suit, value and errorFlag fields equal compareCard
    *         fields, return false otherwise
    */
   public boolean equals(final Card compareCard)
   {
      return compareCard.getSuit() == cardSuit && compareCard.getValue() == value
              && compareCard.getErrorFlag() == errorFlag;
   }

   /**
    * Public Mutator Method for value and cardSuit If arguments are not legal,
    * sets errorFlag to true, false otherwise.
    *
    * @param newValue
    *           the new value for value
    * @param newSuit
    *           the new value for cardSuit
    * @return boolean indicating the success of the value assignment
    */
   public boolean set(char newValue, final Suit newSuit)
   {
      if(!(errorFlag = !isValid(newValue, newSuit))) // check if it is valid and save the error flag
      {
         // if valid we are saving the variables
         cardSuit = newSuit;
         value = newValue;
      }
      // returning whether or not the values are valid.
      return !errorFlag;
   }

   /**
    * Public Accessor Method for value
    *
    * @return the value of value
    */
   public char getValue()
   {
      return value;
   }

   /**
    * Public Accessor Method for cardSuit
    *
    * @return the value of cardSuit
    */
   public Suit getSuit()
   {
      return cardSuit;
   }

   /**
    * Public Accessor Method for errorFlag
    *
    * @return the value of errorFlag
    */
   public boolean getErrorFlag()
   {
      return errorFlag;
   }

   /**
    * Public Static Helper Method
    *
    * This method recursively sorts the argument cards
    * by the valueRank specified in the public static
    * Card variable valueRanks
    *
    * @param cards array of cards in need of sorting
    * @param arraySize length of the cards, this is important for the
    *                  sorting algorithm's recursion
    */
   public static void arraySort(final Card[] cards, int arraySize)
   {
      boolean swapped = false;
      for(int i = 0; i < arraySize; i++)
      {
         if(cardValue(cards[i - 1]) > cardValue(cards[i]))
         {
            final Card temp = cards[i - 1];
            cards[i - 1] = cards[i];
            cards[i] = temp;
            swapped = true;
         }
      }
      if(swapped)
      {
         arraySort(cards, arraySize - 1);
      }
   }

   private static int cardValue(final Card card)
   {
      return Card.valueRanks.length - new String(valueRanks).indexOf(card.getValue());
   }

   /*
   procedure bubbleSort( A : list of sortable items )
    n = length(A)
    repeat
        swapped = false
        for i = 1 to n-1 inclusive do
            if A[i-1] > A[i] then
                swap(A[i-1], A[i])
                swapped = true
            end if
        end for
        n = n - 1
    until not swapped
end procedure
    */

   /**
    * Private helper method to determine validity of checkValue argument. Suit
    * is currently an enum and not checked by this method.
    *
    * @param checkValue
    *           value of value to be validated
    * @param checkSuit
    *           enum parameter included for future use
    * @return true if all arguments are legal, false otherwise
    */
   private boolean isValid(char checkValue, final Suit checkSuit)
   {
      boolean isValidValue = false;

      // Check validity of checkValue against all legalValues
      // set isValidValue to true if valid
      for(char legalValue : LEGAL_VALUES)
      {
         if(checkValue == legalValue)
         {
            isValidValue = true;
         }
      }

      return isValidValue;
   }
}