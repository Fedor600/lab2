package lab2;

public class Worker {
    Name name;
    Department worker;

    public Worker(){
        name = new Name();
    }

    public Worker(String name){
        this();
        if (!setNameWorker(name)){
            throw new IllegalArgumentException("Некорректное имя сотрудника");
        }
    }

    public Worker(String name, Department department){
        this(name);
        setDepartment(department);
    }

    public boolean setNameWorker(String name){
        return this.name.setFullName(name);
    }

    public String getNameWorker(){
        return name.getFullName();
    }

    public void setDepartment(Department department){
        if (this.worker != null){
            this.worker.removeWorker(this);
        }
        this.worker = department;
        if (department != null){
            department.addWorker(this);
        }
    }

    public Department getDepartment(){
        return worker;
    }

    public String showPlaceOfWork(){
        String nameWorker = name.getFullName();
        if (worker == null){
            return nameWorker + " пока не работает в отделе";
        }
        String nameDepartment = worker.getNameDepartment();
        String nameBoss = worker.getNameBoss();

        if (worker.getBoss() == this){
            return nameWorker + " начальник отдела " + nameDepartment;
        }
        String placeOfWork = String.format("%s работает в отделе %s, начальник которого %s",
                                             nameWorker, nameDepartment, nameBoss);
        return placeOfWork;
    }

    @Override
    public String toString(){
        return showPlaceOfWork();
    }
}
