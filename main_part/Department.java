package lab2;

import java.util.ArrayList;

public class Department {
    Worker boss;
    String nameDepartment;
    ArrayList<Worker> workers;

    public Department(){
        workers = new ArrayList<Worker>();
    }

    public Department(String nameDepartment){
        this();
        setNameDepartment(nameDepartment);
    }

    public void appointAsHead(Worker boss){
        if (boss == null){
            return;
        }
        boss.setDepartment(this);
        this.boss = boss;
    }

    public void setNameDepartment(String nameDepartment){
        this.nameDepartment = nameDepartment;
    }

    public String getNameDepartment(){
        return nameDepartment;
    }

    public Worker getBoss(){
        return boss;
    }

    public String getNameBoss(){
        if (boss == null){
            return "не назначен";
        }
        return boss.getNameWorker();
    }

    public void addWorker(Worker worker){
        if (!workers.contains(worker)){
            workers.add(worker);
        }
    }

    public void removeWorker(Worker worker){
        workers.remove(worker);
        if (boss == worker){
            boss = null;
        }
    }

    public ArrayList<Worker> getWorkers(){
        return workers;
    }

    @Override
    public String toString(){
        return getNameDepartment();
    }
}
