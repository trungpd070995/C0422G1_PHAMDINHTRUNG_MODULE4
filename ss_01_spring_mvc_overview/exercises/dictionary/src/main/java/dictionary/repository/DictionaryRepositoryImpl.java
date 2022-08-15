package dictionary.repository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryRepositoryImpl implements IDictionaryRepository {
    private static Map<String, String> translate = new HashMap<>();

    static {
        translate.put("hello", "xin chao");
        translate.put("how", "Thế nào");
        translate.put("book", "Quyển vở");
        translate.put("computer", "Máy tính");
    }

    @Override
    public Map<String, String> getData() {
        return translate;
    }
}
