package com.epam;

public class CoronaDesinfector {
  private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
  private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

  public void start(Room room) {
    announcer.announce("Начинаем дезинфекцию!");
    policeman.makePeopleLeaveRoom();
    desinfect(room);
    announcer.announce("Рискните зайти обратно.");
  }

  private void desinfect(Room room) {
    System.out.println("Молитва: корона, изызи!");
  }
}
