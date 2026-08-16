import java.util.ArrayList;

public class ArrayListNotes
{
    /*
        ArrayLists are essentially resizable Arrays
        When declaring your ArrayList you must give it the type of data it contains in <>
        Size is not required when creating the list
        ArrayLists only work with Objects, no primitive types (int, double, char, etc)
        Must use the object versions of those(Integer, Double, Character ...) when constructing
        the ArrayList
        */
    public static void main(String[] args)
    {
        //constructing an array
        int[] intArray = new int[10];
        String[] stringArray = new String[10];
        MarvelCharacter[] marvelArray = new MarvelCharacter[10];

        //constructing an arrayList - must be an object type
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<String>();
        ArrayList<MarvelCharacter> marvelList = new ArrayList<>();


        //how big
        System.out.println(intArray.length);
        //int size() returns the number of elements in the list
        System.out.println(intList.size());
        /*
        Java naming convention:
            things that are resizable have a size method/property (ArrayList, Map, Set, etc.)
            things that cannon be resized have a length method property (String, array, etc.)
         */

        //adding - basic add
        //boolean add(E obj) appends obj to the end of the list and returns true
        intList.add(1);
        intList.add(10);
        stringList.add("Hello");
        stringList.add(new String("World"));
        marvelList.add(new MarvelCharacter("Iron man", "smart"));
        MarvelCharacter thor = new MarvelCharacter("Thor","god");
        marvelList.add(thor);
        marvelList.add(new MarvelCharacter("Captain America", "super serum"));
        marvelList.add(new MarvelCharacter("Spider-man", "spidey sense"));
        marvelList.add(new MarvelCharacter("Hulk", "strength"));

        //printing
        System.out.println("lists after initial adds");
        System.out.println("intList: " + intList.size());
        System.out.println(intList);
        System.out.println("\nstringList: " + stringList.size());
        System.out.println(stringList);
        System.out.println("\nmarvelList: " + marvelList.size());
        System.out.println(marvelList + "\n");

        //add - 2 param
        //void add(int index, E obj) moves any current objects at index or beyond to the right
        //(to a higher index) and inserts obj at the index
        stringList.add(0, "January");
        System.out.println(stringList);

        marvelList.add(1, new MarvelCharacter("Green Goblin", "goblin formula"));
        System.out.println(marvelList);

        //remove
        //E remove(int index) removes the item at the index and shifts remaining items to the left (to a lower index)
        System.out.println("\n******remove*****");
        String deleted = stringList.remove(0);//remove returns the removed item - not always used
        System.out.println(deleted);
        System.out.println(stringList);
        marvelList.remove(0);
        System.out.println(marvelList);
        marvelList.remove(3);
        System.out.println(marvelList);

        //set
        //E set(int index, E obj) replaces the item at index with obj
        System.out.println("\n*********set*************");
        stringList.set(1, "mom");
        System.out.println(stringList);
        marvelList.set(3, new MarvelCharacter("Dr. Strange", "mystic arts"));
        System.out.println(marvelList);
        //like remove, set also returns the deleted item

        //access
        //E get(int index) returns the item in the list at the index
        System.out.println("\n***************get************");
        System.out.println(stringArray[0]);//array access
        System.out.println(stringList.get(0));
        System.out.println(marvelList.get(2));

        //Loops
        System.out.println("\n***************loops************");
        for (int i = 0; i < marvelList.size(); i++)
        {
            System.out.println(marvelList.get(i));
        }

        //for each
        for(MarvelCharacter m : marvelList)
        {
            System.out.println(m);
        }

        //print just names of the marvel characters
        for(MarvelCharacter m : marvelList)
        {
            System.out.println(m.getName());
        }

        //count the number characters that begin with C
        int count = 0;
        for (MarvelCharacter m : marvelList)
        {
            if(m.getName().charAt(0) == 'C')
                count++;
        }
        System.out.println(count);

        //write code that will put all letters in stringList to upper case
        //can't use for each because Strings do not have modifier methods
        //toUpperCase()
        for (int i = 0; i < stringList.size(); i++)
        {
            //access the current element of the list
            String current = stringList.get(i);
            //make it all caps .toUpperCase()
            String up = current.toUpperCase();
            //change the value in the list to the all caps version
            stringList.set(i, up);

            //or
            //stringList.set(i, stringList.get(i).toUpperCase());
        }
        System.out.println(stringList);



       



//write code that will put all names in marvelList in all caps
        for (int i = 0; i < marvelList.size(); i++)
        {
            //access current item
            MarvelCharacter current = marvelList.get(i);
            //make it all caps .toUpperCase()
            String upper = current.getName().toUpperCase();
            //change the value in the list to the all caps version
            marvelList.get(i).setName(upper);
            //or
            //marvelList.get(i).setName(marvelList.get(i).getName().toUpperCase());

        }
        //MarvelCharacters do have modifier methods, so for each can be used
        for (MarvelCharacter character : marvelList)
        {
            character.setName(character.getName().toUpperCase());
        }

 /** 1/12/2024 notes start copying here if adding to your notes */

        System.out.println("\n*********removing w/ loops**********");
        intList.add(5);
        intList.add(5);
        intList.add(5);
        intList.add(1);
        intList.add(6);
        intList.add(5);
        intList.add(7);
        intList.add(7);
        System.out.println("\nintList before removing");
        System.out.println(intList);
        //todo: remove all 5s



        //adding more characters to make this more interesting
        marvelList.add(new MarvelCharacter("Professor X", "telepathy"));
        marvelList.add(new MarvelCharacter("Thanos", "Titan powers"));
        marvelList.add(new MarvelCharacter("Howard the Duck", "sarcasm"));
        marvelList.add(new MarvelCharacter("Deadpool", "healing"));

        System.out.println("\n marvelList before removals");
        System.out.println(marvelList);
        //todo: remove all marvel characters with spaces in their names

        /** end copy here */



    }
}