package ru.hh.unittestsexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VacancySearchServiceTest {

  // we will test VacancySearchService
  private final VacancySearchService vacancySearchService;
  // we need VacancySearchTestClient to make fixtures
  private final VacancySearchTestClient vacancySearchTestClient;

  public VacancySearchServiceTest() {
    // To keep things simple and to make tests independent, we generate new fresh graph of dependencies for each test.
    // If it becomes slow, you can reuse generated graph between tests.
    // But this is complicated and increases dependencies between tests (hh.ru :-( ).
    // Always keep things as simple as possible... but not simpler.
    final TestGraph testGraph = new TestGraph();
    vacancySearchService = testGraph.vacancySearchService;
    vacancySearchTestClient = testGraph.vacancySearchTestClient;
  }

  @Before
  public void setUp() throws Exception {
    // Method, annotated with @Before, will be executed before each @Test.
    // In this example we use constructor instead.
  }

  @After
  public void tearDown() throws Exception {
    // Method, annotated with @After, will be executed after each @Test.
    // We can clean environment here.
    // In this example we do not need to,
    // because we generate a new fresh environment for each test.
  }
  // There are also @BeforeClass and @AfterClass annotations.

  @Test
  // a little verbose name, but helps to understand quickly the purpose of the test (especially in console)
  public void shouldReturnTermsToCorrespondingVacanciesIds() throws Exception {
    // fixture part
    vacancySearchTestClient.rememberVacanciesIdsOfTerm("android", new HashSet<>(asList(1, 2)));
    vacancySearchTestClient.rememberVacanciesIdsOfTerm("iOS", new HashSet<>(asList(3, 4)));
    final List<String> terms = asList("android", "iOS");

    // call of test method
    final Map<String, Collection<Integer>> termToVacanciesIds =
        vacancySearchService.searchVacanciesIdsByTerms(terms);

    // asserts part (expected vs. actual)
    assertEquals(new HashSet<>(asList(1, 2)), termToVacanciesIds.get("android"));
    assertEquals(new HashSet<>(asList(3, 4)), termToVacanciesIds.get("iOS"));
    // We can come up with more asserts: size of map, size of vacancies ids, etc...
    // But this is unnecessary: 2 asserts above are enough.
  }

  // Corner cases:

  @Test
  public void shouldReturnEmptyMapIfNoSearchTerm() throws Exception {
    final List<String> terms = emptyList();

    final Map<String, Collection<Integer>> termToVacanciesIds =
        vacancySearchService.searchVacanciesIdsByTerms(terms);

    assertTrue(termToVacanciesIds.isEmpty());
  }

  @Test
  public void shouldReturnEmptyCollectionOfVacanciesIdsIfNoVacancyIdFound() throws Exception {
    final List<String> terms = asList("android");

    final Map<String, Collection<Integer>> termToVacanciesIds =
        vacancySearchService.searchVacanciesIdsByTerms(terms);

    assertTrue(termToVacanciesIds.get("android").isEmpty());
  }
}
