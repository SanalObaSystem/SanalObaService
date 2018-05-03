package org.oba.portal;

/**
 * SCENARIO_1
 *
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
/**
 * SCENARIO_2
 *
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/**
 * SCENARIO_3
 *
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
/**
 * SCENARIO_4
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
/**
 * SCENARIO_5	SPRING DATA JPA
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
public class SanalObaPortalApplicationTest {

	/**
	 * SCENARIO_1
	 *
	 */
//	@Test
//	public void contextLoads() {
//	}
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@Test
//	public void givenMemUsers_whenGetPingWithValidUser_thenOk() {
//		ResponseEntity<String> result = makeRestCallToGetPing("mylogin", "pass");
//		assertThat(result.getStatusCodeValue(), org.hamcrest.CoreMatchers.is(100));
//		assertThat(result.getBody(), org.hamcrest.CoreMatchers.is("OK"));
//	}
//
//	@Test
//	public void givenExternalUsers_whenGetPingWithValidUser_thenOK() {
//		ResponseEntity<String> result = makeRestCallToGetPing("externaluser", "pass");
//		assertThat(result.getStatusCodeValue(), org.hamcrest.CoreMatchers.is(200));
//		assertThat(result.getBody(), org.hamcrest.CoreMatchers.is("OK"));
//	}
//
//	@Test
//	public void givenAuthProviders_whenGetPingWithNoCred_then401() {
//		ResponseEntity<String> result = makeRestCallToGetPing();
//		assertThat(result.getStatusCodeValue(), org.hamcrest.CoreMatchers.is(401));
//	}
//
//	@Test
//	public void givenAuthProviders_whenGetPingWithBadCred_then401() {
//		ResponseEntity<String> result = makeRestCallToGetPing("user", "bad_password");
//		assertThat(result.getStatusCodeValue(), org.hamcrest.CoreMatchers.is(401));
//	}
//
//	private ResponseEntity<String> makeRestCallToGetPing(String username, String password) {
//		return restTemplate.withBasicAuth(username, password)
//							.getForEntity("/ping", String.class, Collections.emptyMap());
//	}
//
//	private ResponseEntity<String> makeRestCallToGetPing() {
//		return restTemplate.getForEntity("/ping", String.class, Collections.emptyMap());
//	}

	/**
	 * SCENARIO_2
	 *
	 */
//	@LocalServerPort
//	private int port;
//
//	private URL base;
//
//	@Autowired
//	private TestRestTemplate template;
//
//	@Before
//	public void setUp() throws Exception {
//		this.base = new URL("http://localhost:" + port + "/");
//	}
//
//	@Test
//	public void getHello() throws Exception {
//		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
//		assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
//	}

	/**
	 * SCENARIO_3
	 *
	 */
//	@Autowired
//	private MockMvc mvc;
//
//	@Test
//	public void getHello() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
//											.andExpect(status().isOk())
//											.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
//	}

	/**
	 * SCENARIO_4
	 *
	 */
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//	private MockMvc mockMvc;
//
//	@Before
//	public void setupMockMvc() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//
//	@Test
//	public void givenRequestHasBeenMade_whenMeetsAllOfGivenConditions_thenCorrect() throws Exception { 
//		MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
//		MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//		mockMvc.perform(MockMvcRequestBuilders.get("/entity/all")).
//		andExpect(MockMvcResultMatchers.status().isOk()).
//		andExpect(MockMvcResultMatchers.content().contentType(contentType)).
//		andExpect(jsonPath("$", hasSize(4))); 
//	}

	/**
	 * SCENARIO_5	SPRING DATA JPA
	 *
	 */
//	@Autowired
//	private GenericEntityRepository genericEntityRepository;
//
//	@Test
//	public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
//		GenericEntity genericEntity = genericEntityRepository.save(new GenericEntity("test"));
//		GenericEntity foundedEntity = genericEntityRepository.findOne(genericEntity.getId());
//		assertNotNull(foundedEntity);
//		assertEquals(genericEntity.getValue(), foundedEntity.getValue());
//	}
}
