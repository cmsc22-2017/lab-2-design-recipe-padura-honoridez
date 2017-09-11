import tester.Tester;

// to represent a pet owner
class Person {
  String name;
  IPet pet;
  int age;

  Person(String name, IPet pet, int age) {
    this.name = name;
    this.pet = pet;
    this.age = age;
  }
}
// to represent a pet
interface IPet { }

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

class ExampleIPet {
	ExampleIPet() {}
	
	IPet persian = new Cat("Cathy", "Persian", true);
	IPet sphynx = new Cat("Luke", "Sphynx", false);
	IPet collie = new Dog("Whitie", "Border Collie", true);
	IPet doberman = new Dog("Percy", "Doberman Pincher", false);
}

class ExamplePerson {
	ExamplePerson() {}
	
	Person jack = new Person("Jack", collie, 31);
	Person drew = new Person("Drew", doberman, 15);
	Person luna = new Person("Luna", persian, 20);
	Person rachel = new Person("Rachel", sphynx, 27);
	Person jill = new Person("Jill", collie, 32);
	Person ann = new Person("Ann", doberman, 10);
	Person ranger = new Person("Ranger", persian, 19);
	Person nicole = new Person("Nicole", sphynx, 30);
}