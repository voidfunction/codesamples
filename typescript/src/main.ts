
interface IAnimal {
    eat() : string;
    sleep() : string;
}

class MyDog implements IAnimal {
    
    constructor(private dogName : string,  dogId : number, test : number) {
            
    }

    get name() : string {
        return this.dogName;
    }

    eat() {
      return "dog eat";  
    }

    sleep() {
        return "dog sleep";
    }
}

var myDog = new MyDog("dog", 1234, 45);
document.write(myDog.name +"<br/>");