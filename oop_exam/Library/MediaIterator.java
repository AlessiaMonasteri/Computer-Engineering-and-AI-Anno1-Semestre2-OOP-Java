package Library;

import java.util.Iterator;
import java.util.List;

public class MediaIterator implements Iterator<Media> {
    private List<Media> mediaList;
    private int position = 0;

    public MediaIterator(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    @Override
    public boolean hasNext() {
        return position < mediaList.size();
    }

    @Override
    public Media next() {
        return hasNext() ? mediaList.get(position++) : null;
    }
}

