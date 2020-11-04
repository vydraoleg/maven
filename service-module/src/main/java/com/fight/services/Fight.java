package com.fight.services;


import com.fight.api.entities.Animal;
import com.fight.api.servcies.IAnimalService;
import com.fight.utils.WorkWithFile;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toMap;

public class Fight {

    Map<String, Integer> winners = new ConcurrentHashMap<>(); // List of winners
    Map<Animal, Thread> threadAnimal = new ConcurrentHashMap<>(); // List of saving
    Map<Thread, FightThread> listThread = new ConcurrentHashMap<>();

    public Fight(IAnimalService animalService) {
        this.tournament(animalService);
    }

    /**
     * In end of Tournament print list of winners,
     * sorting and save into file
     */
    private void printWinners(String nameFile) {
        new WorkWithFile().saveJSONToFile(winners, nameFile+".json");
        String myList = " ===== List of winners: ===== \n";

        for (Entry<String, Integer> x : winners.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new)).entrySet()) {
            myList = myList.concat(String.format("Name of winner: %s  Wins: %d \n", x.getKey(), x.getValue()));
        }

        System.out.print(myList);
        new WorkWithFile().saveToFile(myList, nameFile);
    }

    /**
     * Main tournament function
     *
     * @param animalService list of animals for tournament
     */
    private void tournament(IAnimalService animalService) {
        List<Animal> animalFight = animalService.getAnimals();
        System.out.println(" ========== Fight tournament ==========");

        Animal fighter1;
        Animal fighter2;
        int sizeAnimals = animalFight.size();
        for (; ; ) {
            fighter1 = null;
            fighter2 = null;
            // Looking for first fighter
            for (int i = 0; i < sizeAnimals - 1; i++) {
                if (animalFight.get(i).getStrength() > 0 &&
                        !threadAnimal.containsKey(animalFight.get(i))) {
                    fighter1 = animalFight.get(i);
                }
            }
            // Looking for second fighter
            for (int j = 1; j < sizeAnimals; j++) {
                if (animalFight.get(j).getStrength() > 0 &&
                        !animalFight.get(j).equals(fighter1) &&
                        !threadAnimal.containsKey(animalFight.get(j))) {
                    fighter2 = animalFight.get(j);
                }
            }
            // if not exists fighter with strength > 0 and All thread is not alive exit from forever cycle
            if ((fighter1 == null || fighter2 == null) && threadAnimal.isEmpty()) break;

            //Remove all Threads is not Alive
            Iterator<Entry<Animal, Thread>> thread = threadAnimal.entrySet().iterator();
            while (thread.hasNext()) {
                Entry<Animal, Thread> entry = thread.next();
                if (!entry.getValue().isAlive()) {
                    // Save resulting Strength for Second fighter
                    animalService.updateAnimalStrength(entry.getKey().getName(), (int) entry.getKey().getStrength());
                    if (listThread.containsKey(entry.getValue())) {
                        winners = listThread.get(entry.getValue()).getWinners();
                        listThread.remove(entry.getValue());
                    }
// Remove current Animal from list of thread
                    thread.remove();
                }
            }
// Starting thread of Fight
            if (fighter1 != null && fighter2 != null) {
                FightThread fightThread = new FightThread(fighter1, fighter2, winners);
                Thread newThread1 = new Thread(fightThread);
                threadAnimal.put(fighter1, newThread1);
                threadAnimal.put(fighter2, newThread1);
                listThread.put(newThread1, fightThread);
                newThread1.start();
//                fightThread.run();
            }
        }
        printWinners("..\\winners.txt");
    }

}
