# language: ru
Функционал: проверка наличия номера счета 2-го порядка

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

    @3
    Сценарий: проверка наличия номера счета 2-го порядка "202"
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
      И пользователь нажимает кнопку "Найти"
      Тогда отображается "Номер счёта 2-го порядка" содержащий "202"
      И пользователь нажимает кнопку с выпадающим списком "Права  Все"
      И пользователь нажимает кнопку "Выход" в контекстном меню
      И браузер закрыт
