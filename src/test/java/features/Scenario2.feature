# language: ru
Функционал: проверка работы с карточкой актива

  Предыстория:
    Дано открыт браузер и осуществлен переход по ссылке
    И открывается страница с формой "Вход в систему"
    Когда пользователь заполняет поле "Имя пользователя" значением "sua_all"
    И пользователь заполняет поле "Пароль" значением "Q1w2e3r4"
    И пользователь нажимает кнопку "Войти"
    Тогда открывается модальное окно "Выбор финансовой организации"
    * пользователь выбирает финансовую организацию "тест_милион" типа КО из списка
    И пользователь нажимает кнопку "Выбрать"
    Тогда закрывается модальное окно "Выбор финансовой организации"
    Тогда открывается страница с логотипом "Агентство по страхованию вкладов"
    Тогда открывается страница с финансовой организацией "тест_милион"
    Когда пользователь нажимает кнопку с выпадающим списком "Настройка"
    И пользователь выбирает пункт "Справочники"
    Тогда открывается экранная форма "Справочники"
    И пользователь нажимает ссылку "План счетов  по КО" в столбце "Краткое наименование"
    Тогда открывается экранная форма "План счетов по КО"
    И пользователь нажимает кнопку "Поиск" в верхней панели таблицы
    Тогда открывается модальное окно "Поиск..."
    Когда пользователь выбирает пункт "Номер счёта 2-го порядка" в выпадающем списке "ID Плана Счетов"
    И пользователь выбирает пункт "начинается с" в выпадающем списке "содержит"
    И пользователь заполняет поле значением "202"
    И пользователь нажимает на кнопку "Найти"
    Тогда отображается "Номер счёта 2-го порядка" содержащий "202"

  @4
  Сценарий: создание нового актива типа "Денежные средства" для ФО типа КО
    Когда пользователь нажимает кнопку с выпадающим списком "Сбор и ведение данных"
    И пользователь выбирает пункт "Список активов"
    Тогда открывается экранная форма "Список активов"
    Когда пользователь нажимает кнопку "Создать"
    Тогда открывается экранная форма "Создание актива (первый этап)"
    И на экранной форме присутствует поле "Наименование ФО"
    И на экранной форме присутствует поле "Тип актива функциональный"
    И поле "Наименование ФО" недоступно для редактирования
    Когда пользователь выбирает пункт "Денежные средства" в выпадающем списке "Тип актива функциональный"
    И пользователь нажимает кнопку "Далее"
    Тогда открывается экранная форма "Создание актива (второй этап)"
    Когда присутствуют закладки на экранной форме "Создание актива (второй этап)"
   | Основная информация |
   | Приём               |
   | План работы         |
   | Судебная работа     |
   | Инвентаризация      |
   | Хранение            |
   | Аренда              |
   | Оценка              |
   | Реализация          |
   | Списание            |
   | Утилизация          |
   | Связи с активами    |
   | Вовлечённые стороны |
    И пользователь заполняет поле "Номер счёта" значением "20203840123454566678"
    И пользователь заполняет поле "Начальная балансовая стоимость" значением "100000"
    И пользователь заполняет поле "В валюте счёта" значением "2000"
    И пользователь заполняет поле "Наименование актива" значением "Тестов Тест Тестович"
    Тогда содержимое полей "Текущая балансовая стоимость" и "Начальная балансовая стоимость" одинаково
    Тогда содержимое полей "В валюте счёта" и "В валюте счёта" одинаково
    И поле "Валюта счёта" содержит "Доллар США"
    Когда пользователь переходит на вкладку "Приём"
    И пользователь заполняет поле "Дата начала действия актива" значением "02.03.2018"
    И пользователь нажимает клавишу Tab на поле "Дата начала действия актива"
    И пользователь заполняет поле "Дата окончания действия актива" значением "02.05.2018"
    И пользователь нажимает клавишу Tab на поле "Дата окончания действия актива"
    И пользователь нажимает кнопку "Сохранить"
    Когда пользователь нажимает кнопку с выпадающим списком "Сбор и ведение данных"
    И пользователь выбирает пункт "Список активов"
    Тогда открывается экранная форма "Список активов"
    И пользователь нажимает кнопку "Поиск" в верхней панели таблицы
    Тогда открывается модальное окно "Поиск..."
    Когда пользователь выбирает пункт "Номер лицевого счета" в выпадающем списке "Значимый актив"
    И пользователь выбирает пункт "равно" в выпадающем списке "содержит"
    И пользователь заполняет поле значением "20203840123454566678"
    И пользователь нажимает на кнопку "Найти"
    Тогда отображается "Номер лицевого счета" содержащий "20203840123454566678"
    И пользователь нажимает кнопку с выпадающим списком "Права  Все"
    И пользователь нажимает кнопку "Выход" в контекстном меню
    И браузер закрыт