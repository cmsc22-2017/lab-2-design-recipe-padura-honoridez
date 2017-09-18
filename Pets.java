import tester.Tester;

//to represent a pet
interface IPet {
  boolean sameNamePet(String name);
}


// to represent a pet owner
class Human {
  String name;
  IPet pet;
  int age;

  Human(String name, IPet pet, int age) {
    this.name = name;
    this.pet = pet;
    this.age = age;
  }
  
  /* TEMPLATE
   * Fields:
   * ... this.name ...                       -- String
   * ... this.age ...                        -- int
   * ... this.pet ...                        -- IPet
   * 
   * Methods:
   * ... this.isOlder(Human) ...             -- boolean
   * ... this.sameNamePet(String name)...    -- boolean
   * ... this.perished()                     -- Human
   * 
   * Fields of Parameter:
   * ... this.name ...                       -- String
   * ... this.age ...                        -- int
   * ... this.pet ...                        -- IPet
   * 
   * Methods on Parameters:
   * ... this.isOlder(Human) ...             -- boolean
   */
  
  // -> boolean
  // Returns true if one human, compared with another human, is older.
  boolean isOlder(Human that) {
    return this.age > that.age;
  }
  
  // String -> boolean
  // Determines whether a given name matches this person's pet.
  boolean sameNamePet(String name) {
    return this.pet.sameNamePet(name);
  }
  
  // -> Human
  // Returns Person whose pet has perished given this Person.
  Human perished() {
    return new Human(this.name, new NoPet(), this.age);
  }
  
}

class NoPet implements IPet {
  NoPet() {} 
  
  public boolean sameNamePet(String name) {
    return false;
  }
}

// to represent a pet cat
class Cat implements IPet {
  String name;
  String kind;
  boolean longhaired;

  Cat(String name, String kind, boolean longhaired) {
    this.name = name;
    this.kind = kind;
    this.longhaired = longhaired;
    }
  
  public boolean sameNamePet(String name) {
    return this.name.equals(name);
  }
}

// to represent a pet dog
class Dog implements IPet {
  String name;
  String kind;
  boolean male;

  Dog(String name, String kind, boolean male) {
    this.name = name;
    this.kind = kind;
    this.male = male;
  }
  
  public boolean sameNamePet(String name) {
    return this.name.equals(name);
  }
}

class ExampleIPetandPerson {
  ExampleIPetandPerson() {}
  
  IPet persian = new Cat("Cathy", "Persian", true);
  IPet sphynx = new Cat("Luke", "Sphynx", false);
  IPet collie = new Dog("Whitie", "Border Collie", true);
  IPet doberman = new Dog("Percy", "Doberman Pincher", false);
  IPet perished = new NoPet();
	
  Human jack = new Human("Jack", collie, 31);
  Human drew = new Human("Drew", doberman, 15);
  Human luna = new Human("Luna", perished, 20);
  Human rachel = new Human("Rachel", perished, 27);
  Human jill = new Human("Jill", collie, 31);
  Human ann = new Human("Ann", doberman, 10);
  Human ranger = new Human("Ranger", persian, 19);
  Human nicole = new Human("Nicole", sphynx, 30);
	
  boolean testIsOlder(Tester t) {
    return t.checkExpect(nicole.isOlder(rachel), true) && 
          t.checkExpect(jill.isOlder(jack), false) &&
          t.checkExpect(drew.isOlder(ann), true) &&
          t.checkExpect(luna.isOlder(rachel), false);
  }
  
  boolean testSameNamePetFalse(Tester t) {
    return 
           t.checkExpect(drew.sameNamePet("Whitie"), false) && 
           t.checkExpect(jill.sameNamePet("Percy"), false);
  }
  
  boolean testSameNamePetTrue(Tester t) {
    return 
           t.checkExpect(ranger.sameNamePet("Cathy"), true) && 
           t.checkExpect(ann.sameNamePet("Percy"), true); 
  }
  
  boolean testSameNamePetNoPet(Tester t) {
    return t.checkExpect(luna.sameNamePet("Cathy"), false) &&
           t.checkExpect(rachel.sameNamePet("Luke"), false);
  }
  
  boolean testPerished(Tester t) {
    return t.checkExpect(nicole.perished(), new Human("Nicole", perished, 30)) && 
           t.checkExpect(ranger.perished(), new Human("Ranger", perished, 19));
  }

}