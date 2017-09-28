import tester.Tester;

interface ILoPet{
  
  // String -> boolean
  // Returns true if a given name is in the list of pets
  boolean hasPetNamed(String name);
}

class MtLoPet implements ILoPet {
  
  MtLoPet() {}
  
  public boolean hasPetNamed(String name) {
    return false;
  }
}

class ConsLoPet implements ILoPet {
  IPet first;
  ILoPet rest;
  
  ConsLoPet(IPet first, ILoPet rest) {
    this.first = first;
    this.rest = rest;
  }
  
  public boolean hasPetNamed(String name) {
    if (this.first.hasPetNamed(name)) {
      return true;
    } else {
      return this.rest.hasPetNamed(name);
    }
  }
}


//to represent a pet
interface IPet {
  boolean hasPetNamed(String name);
  boolean equals(Object o);
}


//to represent a pet owner
class Human {
String name;
ILoPet pet;
int age;

Human(String name, ILoPet pet, int age) {
  this.name = name;
  this.pet = pet;
  this.age = age;
}

/* TEMPLATE
 * Fields:
 * ... this.name ...                       -- String
 * ... this.age ...                        -- int
 * ... this.pet ...                        -- ILoPet
 * 
 * Methods:
 * ... this.isOlder(Human) ...             -- boolean
 * ... this.hasPetNamed(String name)...    -- boolean
 * 
 * Methods on ILoPet:
 * ... this.pet.hasPetNamed(String name)...   -- boolean
 * 
 * 
 */

  // -> boolean
  // Returns true if one human, compared with another human, is older.
  boolean isOlder(Human that) {
    return this.age > that.age;
  }

  // String -> boolean
  // Determines whether a given name matches this person's pet.
  boolean hasPetNamed(String name) {
    return pet.hasPetNamed(name);
  }
}

//to represent a pet cat
class Cat implements IPet {
String name;
String kind;
boolean longhaired;

Cat(String name, String kind, boolean longhaired) {
  this.name = name;
  this.kind = kind;
  this.longhaired = longhaired;
  }


public boolean hasPetNamed(String name) {
  return this.name.equals(name);
}

public boolean equals(Object o) {
  if (o instanceof Cat) {
    Cat c = (Cat) o;
    return this.name.equals(c.name);
  } else {
    return false;
  }
}

}

//to represent a pet dog
class Dog implements IPet {
String name;
String kind;
boolean male;

Dog(String name, String kind, boolean male) {
  this.name = name;
  this.kind = kind;
  this.male = male;
}


public boolean hasPetNamed(String name) { 
  return this.name.equals(name);
}

public boolean equals(Object o) {
  if (o instanceof Cat) {
    Cat c = (Cat) o;
    return this.name.equals(c.name);
  } else {
    return false;
  }
  }
}


class ExampleILoPet {
ExampleILoPet() {}

IPet persian = new Cat("Cathy", "Persian", true);
IPet sphynx = new Cat("Luke", "Sphynx", false);
IPet collie = new Dog("Whitie", "Border Collie", true);
IPet doberman = new Dog("Percy", "Doberman Pincher", false);
ILoPet mt = new MtLoPet();
ILoPet dogs = new ConsLoPet(collie, new ConsLoPet(doberman, mt));
ILoPet cats = new ConsLoPet(persian, new ConsLoPet(sphynx, mt));

Human jack = new Human("Jack", dogs, 31);
//Human drew = new Human("Drew", doberman, 15);
//Human luna = new Human("Luna", perished, 20);
//Human rachel = new Human("Rachel", perished, 27);
//Human jill = new Human("Jill", collie, 31);
//Human ann = new Human("Ann", doberman, 10);
//Human ranger = new Human("Ranger", persian, 19);
//Human nicole = new Human("Nicole", sphynx, 30);

//boolean testIsOlder(Tester t) {
//  return t.checkExpect(nicole.isOlder(rachel), true) && 
//        t.checkExpect(jill.isOlder(jack), false) &&
//        t.checkExpect(drew.isOlder(ann), true) &&
//        t.checkExpect(luna.isOlder(rachel), false);
//}

boolean testHasPetNamedTrue(Tester t) {
  return t.checkExpect(dogs.hasPetNamed("Percy"), true);  
}

boolean testHasPetNamedFalse(Tester t) {
  return t.checkExpect(dogs.hasPetNamed("Baldo"), false);
}

}