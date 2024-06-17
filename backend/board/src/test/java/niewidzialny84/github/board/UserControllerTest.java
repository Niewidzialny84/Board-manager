package niewidzialny84.github.board;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import niewidzialny84.github.board.models.User;
import niewidzialny84.github.board.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integration-test.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest
{
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    private static final String FIRST_USER = "{\"userID\":1,\"name\":\"Json\",\"key\":null,\"boardList\":[]}";

    @BeforeAll
    public void beforeAll()
    {
        userRepository.save(new User("Json"));
    }

    @Test
    public void getAllUsersTest() throws Exception
    {
        mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().string("[" + FIRST_USER + "]"));
    }

    @Test
    public void getUser() throws Exception
    {
        mvc.perform(get("/users/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(FIRST_USER));
    }
}
