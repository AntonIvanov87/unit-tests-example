package ru.hh.unittestsexample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyList;

// Primitive test implementation of VacancySearchClient.
// One can mock this interface (using mockito library, for example).
// But this implementation is more reusable (you do not need to reinvent mock for each test)
// and more incapsulated (you do not need to know whether you have mocked it right or not).
class VacancySearchTestClient implements VacancySearchClient {

  private final Map<String, Collection<Integer>> termToVacanciesIds = new HashMap<>();

  void rememberVacanciesIdsOfTerm(final String term, final Collection<Integer> vacanciesIds) {
    termToVacanciesIds.put(term, vacanciesIds);
  }

  @Override
  public Collection<Integer> searchVacanciesIdsByTerm(final String term) {
    final Collection<Integer> vacanciesIds = termToVacanciesIds.get(term);
    if (vacanciesIds == null) {
      return emptyList();
    }
    return vacanciesIds;
  }
}
