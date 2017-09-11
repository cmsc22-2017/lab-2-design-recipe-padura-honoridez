import tester.Tester;

//to represent a pet
interface IPet { }


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
   * ... this.name ...          -- String
   * ... this.age ...           -- int
   * ... this.pet ...           -- IPet
   * 
   * Methods:
   * ... this.isOlder(Human) ...       -- boolean
   * 
   * Fields of Parameter:
   * ... this.name ...          -- String
   * ... this.age ...           -- int
   * ... this.pet ...           -- IPet
   * 
   * Methods on Parameters:
   * ... this.isOlder(Human) ...       -- boolean
   */
  
  // -> boolean
  // Returns true if one human, compared with another human, is older.
  boolean isOlder(Human that) {
    return this.age > that.age;
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
}

class ExampleIPetandPerson {
	ExampleIPetandPerson() {}

	IPet persian = new Cat("Cathy", "Persian", true);
	IPet sphynx = new Cat("Luke", "Sphynx", false);
	IPet collie = new Dog("Whitie", "Border Collie", true);
	IPet doberman = new Dog("Percy", "Doberman Pincher", false);
	
	Human jack = new Human("Jack", collie, 31);
	Human drew = new Human("Drew", doberman, 15);
  Human luna = new Human("Luna", persian, 20);
  Human rachel = new Human("Rachel", sphynx, 27);
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
}


