package fominskiy;

public class Main {
    public static void main(String[] args) {
        LinkList linkList2 = new LinkList();


        linkList2.insert(12,0);
        linkList2.insert(13,1);
        linkList2.insert(14,2);
        linkList2.insert(15,3);
        linkList2.insert(16,4);


        System.out.println(linkList2.get(0));
        System.out.println(linkList2.get(1));
        System.out.println(linkList2.get(2));
        System.out.println(linkList2.get(3));
        System.out.println(linkList2.get(4));

        linkList2.remove(13);

        System.out.println(linkList2.get(0));
        System.out.println(linkList2.get(1));
        System.out.println(linkList2.get(2));
        System.out.println(linkList2.get(3));





    }
}


