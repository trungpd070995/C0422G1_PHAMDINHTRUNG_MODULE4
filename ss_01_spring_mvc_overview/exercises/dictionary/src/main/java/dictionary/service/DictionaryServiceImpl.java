package dictionary.service;

import dictionary.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {

    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String value(String vietnamese) {
        Map<String, String> translate = dictionaryRepository.getData();
        String result = translate.get(vietnamese);
        if (result == null) {
            return "khong dich duoc";
        }
        return result;
    }
}
