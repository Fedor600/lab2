package lab2;

import Input.Reader;

public class Executor {

    public Executor(){
    }

    public void start(){
        int choice = -1;
        Reader reader = new Reader();

        System.out.println("Добро пожаловать в меню!");
        do{
            System.out.println("=== Меню ===");
            System.out.println("1) Задание 1.3 - Имена");
            System.out.println("2) Задание 1.4 - Время");
            System.out.println("3) Задание 2.4 - Сотрудники и отделы");
            System.out.println("4) Задание 3.4 - Список сотрудников отдела");
            System.out.println("5) Задание 4.4 - Создаем время");
            System.out.println("6) Задание 5.4 - Сколько сейчас времени?");
            System.out.println("0) Выход из меню");
            System.out.print("Ваш выбор: ");
            choice = reader.readInt();
            reader.readLine(); // Убираем перевод строки после числа.

            switch (choice){
                case 1:
                    Name name = new Name();
                    System.out.println("Введите имя (Фамилия Имя Отчество, можно не все части):");
                    String line1 = reader.readLine();
                    while(!name.setFullName(line1)){
                        System.out.println("Ошибка! Введите от одного до трех слов:");
                        line1 = reader.readLine();
                    }
                    System.out.println("Введено: " + name);
                    break;
                case 2:
                    System.out.println("Введите количество секунд:");
                    long seconds = reader.readLong();
                    while(seconds < 0){
                        System.out.println("Число должно быть неотрицательным. Повторите:");
                        seconds = reader.readLong();
                    }
                    Time time1 = new Time();
                    time1.setSecondTime(seconds);

                    System.out.println("Ваше время: " + time1);
                    reader.readLine();
                    break;
                case 3:
                    Worker worker1 = new Worker();
                    Worker worker2 = new Worker();
                    Worker worker3 = new Worker();
                    Department department1 = new Department();

                    worker1.setNameWorker("Петров");
                    worker2.setNameWorker("Козлов");
                    worker3.setNameWorker("Сидоров");
                    department1.setNameDepartment("IT");
                    worker1.setDepartment(department1);
                    worker2.setDepartment(department1);
                    worker3.setDepartment(department1);
                    department1.appointAsHead(worker2);

                    System.out.println(worker1);
                    System.out.println(worker2);
                    System.out.println(worker3);
                    break;
                case 4:
                    Worker worker4 = new Worker();
                    Worker worker5 = new Worker();
                    Worker worker6 = new Worker();
                    Department department2 = new Department();

                    worker4.setNameWorker("Петров");
                    worker5.setNameWorker("Козлов");
                    worker6.setNameWorker("Сидоров");
                    department2.setNameDepartment("IT");
                    worker4.setDepartment(department2);
                    worker5.setDepartment(department2);
                    worker6.setDepartment(department2);
                    department2.appointAsHead(worker5);

                    // Получаем список отдела через сотрудника.
                    System.out.println("Сотрудники отдела " + worker4.getDepartment().getNameDepartment() + ":");
                    for (Worker worker : worker4.getDepartment().getWorkers()){
                        System.out.println(worker.getNameWorker());
                    }
                    break;
                case 5:
                    Time time4 = new Time();
                    String line2 = reader.readLine();
                    time4.setTime(line2);
                    System.out.println("Ответ: " + time4);
                    break;
                case 6:
                    Time time6 = new Time();
                    Time time7 = new Time();
                    Time time8 = new Time();

                    time6.setSecondTime(34056);
                    time7.setSecondTime(4532);
                    time8.setSecondTime(123);

                    System.out.println("Час для 34056 секунд: " + time6.getHour());
                    System.out.println("Минуты для 4532 секунд: " + time7.getMinute());
                    System.out.println("Секунды для 123 секунд: " + time8.getSecond());
                    break;
                case 0:
                    System.out.println("Вы вышли из меню.");
                    break;
                default:
                    System.out.println("Такого задания нет. Попробуйте ещё раз.");
                    break;
            }
        }while(choice != 0);
    }
}
