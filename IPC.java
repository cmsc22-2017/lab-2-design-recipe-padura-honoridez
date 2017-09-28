import tester.Tester;

interface ILoPC {
  // -> int
  // Returns the number of players that rely on this player 
  // including this player him/herself
  int countPlayers();
  
  // -> int
  // Returns the number of players that rely on this player's phone call excluding this player
  int countPlayersCalled();
  
  // String -> boolean
  // Returns true if this player will be able to call a given name
  boolean willCall(String name);
  
  String getName();
  
  // -> int
  // Returns the number of sequence of phone calls that have to be made to reach any of the players.
  int longestChain();
  
  int longestChainCounter();
}

class MtLoPC implements ILoPC {
  MtLoPC() {}


  public String getName() {
    return "";
  }
  
  public int countPlayers() {
    return 0;
  }

  public int countPlayersCalled() {
    return 0;
  }

  public boolean willCall(String name) {
    return false;
  }


  
  public int longestChain() {
    return 0;
  }


  public int longestChainCounter() {
    return 0;
  }
  
}

class ConsLoPC implements ILoPC {
  String name;
  ILoPC pass1;
  ILoPC pass2;
  
  ConsLoPC(String name,ILoPC pass1, ILoPC pass2) {
    this.name = name;
    this.pass1 = pass1;
    this.pass2 = pass2;
  }

 /* TEMPLATE
  *   Fields:
  *     ...this.name...       -- String
  *     ...this.pass1...      -- ILoPC
  *     ...this.pass2...      -- ILoPC
  *   
  *   Methods:
  *     ...this.countPlayers()...    -- int
  *     ...this.countPlayersCalled()...   -- int
  *     ...this.willCall(String)...   -- boolean
  *     ...this.getName()...     -- String
  * 
  *   
  *   Methods on pass1:
  *     ...this.pass1.countPlayers() -- int
  *     ...this.pass1.countPlayersCalled()...   -- int
  *     ...this.pass1.willCall(String)...   -- boolean
  *     ...this.pass1.getName()     -- String
  *   
  *   Methods on pass2:
  *     ...this.pass2.countPlayers() -- int
  *     ...this.pass2.countPlayersCalled()...   -- int
  *     ...this.pass2.willCall(String)...   -- boolean
  *     ...this.pass2.getName()     -- String
  *       
  */
  
  // -> String
  // Returns the name of this Player
  public String getName() {
    return this.name;
  }
  
  public int countPlayers() {
    return 1 + this.pass1.countPlayers() + this.pass2.countPlayers();
  }


  public int countPlayersCalled() {
    return this.countPlayers() - 1;
  }


  public boolean equals(Object o) {
    if (o instanceof ConsLoPC) {
      ConsLoPC c = (ConsLoPC) o;
      return this.name.equals(c.name);
    } else {
      return false;
    }
  }
  
  public boolean willCall(String name) {
    return pass1.willCall(name) || pass2.willCall(name) || this.name.equals(name);
  }

  public int longestChainCounter() {
    int counter;
    if (pass1.longestChainCounter() > pass2.longestChainCounter()) {
      counter =  1 + pass1.longestChainCounter();
    } else {
      counter = 1 + pass2.longestChainCounter();
    }
    return counter;
  }
  
  public int longestChain() {
    return longestChainCounter() - 1;
  }
  
}



class ExamplesILoPC {
  ExamplesILoPC() {}
  
  
  ILoPC empty = new MtLoPC();
  ILoPC tay = new ConsLoPC("Tay", empty, empty);
  ILoPC zoe = new ConsLoPC("Zoe", empty, empty);
  ILoPC meg = new ConsLoPC("Meg", empty, empty);
  ILoPC lou = new ConsLoPC("Lou", empty, empty);
  ILoPC cam = new ConsLoPC("Cam", empty, empty);
  ILoPC eve = new ConsLoPC("Eve", empty, empty);
  ILoPC tam = new ConsLoPC("Tam", empty, empty);
  ILoPC joy = new ConsLoPC("Joy", tam, empty);
  ILoPC ann = new ConsLoPC("Ann", cam, eve);
  ILoPC pat = new ConsLoPC("Pat", meg, lou);
  ILoPC kim = new ConsLoPC("Kim", tay, zoe);
  ILoPC may = new ConsLoPC("May", kim, pat);
  ILoPC bea = new ConsLoPC("Bea", joy, ann);
  ILoPC jen = new ConsLoPC("Jen", bea, may);
  
  boolean testCountPlayersMt(Tester t) {
    return t.checkExpect(empty.countPlayers(), 0);
  }
  
  boolean testCountPlayers(Tester t) {
    return t.checkExpect(kim.countPlayers(), 3) &&
           t.checkExpect(jen.countPlayers(), 14) && 
           t.checkExpect(tay.countPlayers(), 1);
  }
  
  boolean testCountPlayersCalledMt(Tester t) {
    return t.checkExpect(empty.countPlayersCalled(), 0);
  }
  
  boolean testCountPlayersCalled(Tester t) {
    return t.checkExpect(kim.countPlayersCalled(), 2) &&
           t.checkExpect(jen.countPlayersCalled(), 13) && 
           t.checkExpect(tay.countPlayersCalled(), 0);
  }
  
  boolean testWillCallMt(Tester t) {
    return t.checkExpect(empty.willCall("Zoe"), false);
  }
  
  boolean testWillCall(Tester t) {
    return t.checkExpect(kim.willCall("Tay"), true) &&
           t.checkExpect(jen.willCall("Tam"), true) && 
           t.checkExpect(tay.willCall("Jean"), false);
  }  
  
  boolean testlongestChain(Tester t) {
    return t.checkExpect(bea.longestChain(), 2) &&
           t.checkExpect(jen.longestChain(), 3) &&
           t.checkExpect(tay.longestChain(), 0);
  }  
  
 }