package app.service;

import app.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NoteService {

        private Map<Long, Note> noteMap = new HashMap<>();

        public Map<Long, Note> listAll() {
            return noteMap;
        }

        public Note add(Note note) {
            Long id = generateId();
            note.setId(id);
            noteMap.put(id, note);
            return note;
        }

        public void deleteById(long id) {
            if (!noteMap.containsKey(id)) {
                throw new RuntimeException("Note with id " + id + " not found");
            }
            noteMap.remove(id);
        }

        public void update(Note note) {
            if (!noteMap.containsKey(note.getId())) {
                throw new RuntimeException("Note with id " + note.getId() + " not found");
            }
            noteMap.put(note.getId(), note);
        }

        public Note getById(long id) {
            if (!noteMap.containsKey(id)) {
                throw new RuntimeException("Note with id " + id + " not found");
            }
            return noteMap.get(id);
        }

        private Long generateId() {
            return Math.round(Math.random() * 1000000);
        }
}
