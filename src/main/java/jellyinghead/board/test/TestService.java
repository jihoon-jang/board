package jellyinghead.board.test;

import jellyinghead.board.test.model.TestModel;
import jellyinghead.board.test.model.TestModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestModelRepository testModelRepository;

    public TestModel getTestModel(int no) {
        return testModelRepository.getReferenceById(no);
    }

    public void addTestModel() {
        TestModel testModel = TestModel.builder()
                .name("jpa test ----")
                .build();
        testModelRepository.save(testModel);
    }

    public void updateTestModel() {
        TestModel testModel = TestModel.builder()
                .no(1)
                .name("update name")
                .build();
        testModelRepository.save(testModel);
    }

    public void deleteTestModel() {
        testModelRepository.deleteById(2);
    }

}
