package repository;

import entity.Todolist;

public class TodoListRepositoryImpl implements TodoListRepository {

    public Todolist[] data = new Todolist[10];


    @Override
    public Todolist[] getAll() {
        return data;
    }

    public boolean isFull(){
        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                // model masih ada yg kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
        // jika penuh, resize ukuran array 2 kali lipat
        if (isFull()) {
            var temp = data;
            data = new Todolist[data.length * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(Todolist todolist) {
        resizeIfFull();
        // tambahkan ke posisi yg data array nya null
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer num) {
        if ((num - 1) >= data.length) {
            return false;
        } else if (data[num - 1] == null) {
            return false;
        } else {
            for (int i = (num - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
