package ru.hh.unittestsexample;

// Primitive graph of dependencies common for production and tests.
// To keep things simple, we do not use IoC framework (Spring, Guice, Dagger, etc), but use plain java instead.
final class CommonGraph {

  final VacancySearchClient vacancySearchClient;
  final VacancySearchService vacancySearchService;
  final VacancySearchController vacancySearchController;

  CommonGraph(final VacancySearchClient vacancySearchClient) {
    this.vacancySearchClient = vacancySearchClient;
    vacancySearchService = new VacancySearchService(vacancySearchClient);
    vacancySearchController = new VacancySearchController(vacancySearchService);
  }
}
