package com.northvine.engineering.cards;

/**
 * The Deck class is a data structure for storing information representing the
 * Deck or Decks used in a game of cards.
 *
 * @Author Gene Evans, Kyle Luoma, Trammel May, Trent Dehart
 * @Date May 26th, 2017
 * @Version 1.0.0
 */
public class Deck
{
   //Public Data Members:
   public final int MAX_CARDS = 320;
   public Card[] cards;

   //Private Data Members:
   private static Card[] masterPack = new Card[56];
   private int topCard;
   private int numPacks;

   /**
    * Public Default Constructor
    *
    * The constructor initializes a standard Deck of 52 cards when there are no
    * parameters given when called.
    *
    * allocateMasterPack creates the standard Deck that the public variable
    * cards will reference when init is called.
    */
   public Deck()
   {
      allocateMasterPack();
      init(numPacks = 1);
   }

   /**
    * Public Constructor
    *
    * @param numPacks
    *           number of decks determined by call
    */
   public Deck(int numPacks)
   {
      allocateMasterPack();
      init(numPacks);
   }

   /**
    * Public Mutator Method
    *
    * This method reinitializes the Deck(s) to the standard format determined by
    * the private variable masterPack. It first sets the values in the public
    * variable cards to null, then sets the each index to the corresponding Card
    * object from masterPack. It will also reset the pointer for the top of the
    * cards array topCard.
    *
    * @param numPacks
    *           number of decks determined by call to Constructor
    */
   public void init(int numPacks)
   {
      if(numPacks > 0 && numPacks < (MAX_CARDS / 56))
      {
         cards = new Card[numPacks * 56];
         int packCount = 0;
         for(int i = 0; i < numPacks; i++)
         {
            for(Card pulledCard : masterPack)
            {
               cards[packCount] = pulledCard;
               packCount++;
            }
         }
         topCard = cards.length - 1;
      }
      else
      {
         System.err.println("Cannot initialize deck. "
                 + "Number of cards either exceeds or does not reach "
                 + "the card boundaries.");
      }

   }

   /**
    * Public Mutator Method
    *
    * This method shuffles the Card objects within the public cards array using
    * for loops and a random number generator.
    */

   public void shuffle()
   {
      int cursor = cards.length - 1; //Delineates between shuffled and unshuffled portions of cards array
      for(int i = 0; i < cards.length && cursor > 0; i++)
      {
         int randomNumber = new java.util.Random().nextInt(cursor + 1); //Generate a random num between 0 and length of unshuffled side of array
         Card pulledCard = cards[randomNumber]; //save the randomly selected card in a temporary object
         for(int j = randomNumber; j < cursor; j++) //shift all unshuffled cards left by one index
         {
            cards[j] = cards[j + 1];
         }
         cards[cursor--] = pulledCard; //Place pulled card at cursor, shift cursor left and repeat
      }
   }

   /**
    * Public Accessor/Mutator Method
    *
    * Uses the method inspectCard and the array pointer topCard to identify the
    * Card object at the end of the public cards array. It will also remove the
    * card from the Deck, setting the object at the index to null, and updating
    * topCard. If called upon an empty deck, will return a card with an illegal
    * value that sets its errorFlag to true.
    *
    * @return the last Card object within the cards array.
    */
   public Card dealCard()
   {
      if(topCard >= 0) //Checks that there are still cards in the deck
      {
         final Card pulledCard = new Card(inspectCard(topCard)); //stores a temp location of top card deep copy
         cards[topCard--] = null; //sets the index of the cards array to null and decrements the top card
         return pulledCard;
      }
      else
      {
         return new Card('?', Card.Suit.DIAMONDS);
      }
   }

   /**
    * Public Mutator Method
    *
    * This method sorts the array of cards
    * based on the ranking values described in
    * the Card class.
    */
   public void sort()
   {
      Card.arraySort(cards, cards.length);
   }

   /**
    * Public Accessor Method
    *
    * @return the index of the top card in the cards array.
    */
   public int getTopCard()
   {
      return topCard; // TODO this may not be correct?
   }

   /**
    * Public Access Method
    *
    * @return the number of cards in the deck
    */
   public int getNumCards()
   {
      return topCard;
   }

   /**
    * Public Mutator Method
    *
    * This method will check if there is room in the deck
    * for another card of the argument Card's type and value.
    * if there is, this method will append it to the deck.
    *
    * @param card to be appended to the deck
    * @return boolean representing the success of the addition.
    */
   public boolean addCard(final Card card)
   {
      for(int i = 0, found = 0; i < topCard; i++)
      {
         if(cards[i].equals(card)) // check if we have found the card
         {
            if((++found) > numPacks) // increment found and check if we have found too many
            {
               return false;
            }
         }
      }
      cards[topCard++] = card;
      return true;
   }

   /**
    * Public Mutator Method
    *
    * This method will check if the argument Card exists
    * in the deck. If it does, it will remove it and swap
    * it in place with the top card. The deck size is
    * decremented by one.
    *
    * @param card to be removed from the deck
    * @return boolean representing the success of the deletion
    */
   public boolean removeCard(final Card card)
   {
      for(int i = 0; i < topCard; i++)
      {
         if(cards[i].equals(card))
         {
            cards[i] = cards[topCard]; // swap removed card with top card
            cards[topCard--] = null; // decrement top card
            return true;
         }
      }
      return false;
   }

   /**
    * Public Accessor Method
    *
    * This method takes an integer argument that determines the indec of the
    * public cards array to be checked. It will check if the index is greater
    * than or equal to the array pointer topCard, and return either the
    * designated card, or a card value that will set the errorFlag to true.
    *
    * @param k
    *           the index of the cards array to be called.
    * @return the Card object within the cards array, or a card that will set
    *         the errorFlag in the Card class to true.
    */
   public Card inspectCard(int k)
   {
      return k <= topCard ? cards[k] : new Card('?', Card.Suit.DIAMONDS);
   }

   /**
    * Private Mutator Method
    *
    * This method initiates a standard deck of 52 cards. It has an if statement
    * to check if the masterPack has already been created by the Deck class. It
    * uses the public char[] LEGAL_VALUES from the Card class to set legal
    * values of Card objects into masterPack.
    */
   private static void allocateMasterPack()
   {
      if(masterPack[0] == null) //checks to see if masterPack is already initialized.
      {
         int packIndex = 0; //counter for masterPack indexes.
         for(Card.Suit suit : Card.Suit.values())
         {
            for(char legalValue : Card.LEGAL_VALUES)
            {
               masterPack[packIndex++] = new Card(legalValue, suit);
            }
         }
      }
   }
}