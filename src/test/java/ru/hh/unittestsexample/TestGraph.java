package ru.hh.unittestsexample;

// Primitive graph of test dependencies.
final class TestGraph {

  final VacancySearchTestClient vacancySearchTestClient;
  final VacancySearchService vacancySearchService;
  final VacancySearchController vacancySearchController;

  TestGraph() {
    vacancySearchTestClient = new VacancySearchTestClient();

    final CommonGraph commonGraph = new CommonGraph(vacancySearchTestClient);
    vacancySearchService = commonGraph.vacancySearchService;
    vacancySearchController = commonGraph.vacancySearchController;
  }
}
