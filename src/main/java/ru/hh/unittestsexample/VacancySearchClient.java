package ru.hh.unittestsexample;

import java.util.Collection;

// Level of remote calls.
// Remote calls are likely to be stubbed.
// That is why this interface will have at least 2 implementations: production and test.
// Also we can be more inventive and mock not method calls, but rather http calls, but this is a different story.
interface VacancySearchClient {
  Collection<Integer> searchVacanciesIdsByTerm(String term);
}
