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
      CLUBS, DIAMONDS, HEARTS, SPADES
   };

   //Public Static Data Members:
   public static final char[] LEGAL_VALUES =
   {
         'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'
   };

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
    *           com.northvine.engineering.cards.Card object
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
    *         com.northvine.engineering.cards.Card object returns ** illegal **
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
