package ru.hh.unittestsexample;

// Primitive graph of production dependencies
final class ProdGraph {

  final VacancySearchController vacancySearchController;

  ProdGraph() {
    final VacancySearchClient vacancySearchClient = new VacancySearchClientImpl("prodHost", 1234);

    final CommonGraph commonGraph = new CommonGraph(vacancySearchClient);
    vacancySearchController = commonGraph.vacancySearchController;
  }
}
