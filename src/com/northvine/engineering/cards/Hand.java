package com.northvine.engineering.cards;

/**
 * The Hand class is a data structure for storing information representing an
 * individual Hand that may be contained within a Deck.
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 10th, 2017
 * @Version 1.0.0
 */
public class Hand
{
   // Public Data Members
   public static final int MAX_CARDS = 50; // Max number of cards allowed

   // Private Data Members
   private Card[] myCards; // Cards in users hand
   private int numCards; // helper variable to track card array size

   /**
    * Default Constructor
    *
    * This constructor initializes an empty hand of cards. It is important to
    * note that this hand has a capacity limit expressed by the static variable
    * MAX_CARDS.
    */
   public Hand()
   {
      resetHand();
   }

   /**
    * Public Mutator Method
    *
    * This method takes an argument card object and appends a deep copy of the
    * object to the card array. It will not allow the calling object to append
    * cards past the MAX_CARDS limitation.
    *
    * @param card
    *           this is the card you would like to add to the hand
    * @return boolean condition representing whether or not the card was
    *         successfully added to the hand. if the hand is full, it will
    *         return false.
    */
   public boolean takeCard(final Card card)
   {
      if(numCards >= MAX_CARDS)
      {
         return false;
      }
      /*
       * Set the card at the top of the array to a deep copy of the card
       * increment the number of cards and then return whether or not it was
       * successful by calling the negation of the deep copy's error flag.
       */
      return !(myCards[numCards++] = new Card(card)).getErrorFlag();
   }

   /**
    * Public Accessor/Mutator Method
    *
    * This method returns the top card of the hand. In other words, the highest
    * index of the deck is returned. This card is also removed from the list of
    * cards.
    *
    * @return the "top" card in the hand. If the hand is empty, an invalid state
    *         card will be returned.
    */
   public Card playCard()
   {
      if(numCards <= 0)
      {
         return new Card('?', Card.Suit.DIAMONDS);
      }
      Card card = new Card(myCards[--numCards]); // cache temp location of top card deep copy
      myCards[numCards] = null; // implicitly call destructor by re-assigning to null
      return card; // return deep copy
   }

   /**
    * Public Accessor Method
    *
    * This method returns the current number of cards in the hand.
    *
    * @return an integer representing the current number of cards in the hand
    */
   public int getNumCards()
   {
      return numCards;
   }

   /**
    * Public Accessor Method
    *
    * This method takes an argument integer representing the index of a card in
    * the hand to be returned. This does not remove the card at that index from
    * the array. It will return an invalid card if the index is out of bounds.
    *
    * @param k
    *           the card index of the desired card
    * @return the Card at the argument index, or an card with an invalid state
    *         if the index is illegal.
    */
   public Card inspectCard(int k)
   {
      /*
       * if k is less than the current index cap, return the card at that index,
       * otherwise return an illegal state card
       */
      return k < numCards ? myCards[k] : new Card('?', Card.Suit.DIAMONDS);
   }

   /**
    * Public Mutator Method
    *
    * This method resets the hand by assigning the card array to a new array of
    * cards. The array destructor is implicitly called. The number of cards is
    * also reset to 0;
    */
   public void resetHand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }

   public void sort()
   {
      Card.arraySort(myCards, numCards);
   }

   /**
    * Public Accessor Method
    *
    * This method overrides the Object toString() method
    *
    * @return a string of all cards in the hand. The toString() method is called
    *         on all the individual cards and appending to the returned string.
    */
   @Override
   public String toString()
   {
      String sb = "( ";
      for(int i = 0; i < numCards; i++)
      {
         if(i + 1 >= numCards)
         {
            sb += (String.format("%s ", myCards[i])); // if last card, don't add comma
         }
         else
         {
            sb += (String.format("%s, ", myCards[i])); // not last card, append with comma
         }
      }
      return sb += ")";
   }
}