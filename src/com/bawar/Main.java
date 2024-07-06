package com.bawar;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1", "Mohd Rafi");

        album.addSong("Chand Mera Dil", 4.5);
        album.addSong("Khoya Khoya Chand", 3.5);
        album.addSong("Likhe Jo Khath", 5.5);
        albums.add(album);

        album = new Album("Album2", "Sanam Puri");

        album.addSong("Yeh Raat bheegi bheegi", 7.5);
        album.addSong("Gulabi Aankhen", 6.5);
        album.addSong("Ooo Mere Dil Ke chain", 8.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Chand Mera Dil",playList_1);
        albums.get(0).addToPlayList("Khoya Khoya Chand",playList_1);
        albums.get(1).addToPlayList("Yeh Raat bheegi bheegi",playList_1);
        albums.get(1).addToPlayList("Ooo Mere Dil Ke chain",playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playlist have no song");
        }
        else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }
                    else{
                        System.out.println("No song available, reached to the end of the list");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }
                    else{
                        System.out.println("We are at the first song");
                        forward = false;
                        break;
                    }

                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("We are at the start of the list");
                        }
                    }
                    else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("We have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                        }
                        else{
                            if (listIterator.hasPrevious())
                                System.out.println("Now playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("------------------------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("------------------------------");
    }

}
