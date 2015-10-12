package ru.hh.unittestsexample;

import java.util.List;

import static java.util.Arrays.asList;

public final class Main {

  public static void main(final String[] args) {
    // pretend that this code bootstraps your application
    final VacancySearchController vacancySearchController = new ProdGraph().vacancySearchController;

    // pretend that this code emulates some activity
    final List<String> terms = asList(args);
    System.out.println("asking vacancies ids of " + terms + "...");
    final String reply = vacancySearchController.searchVacanciesIdsByTerms(terms);
    System.out.println("got: " + reply);
  }

  private Main() {
  }
}
