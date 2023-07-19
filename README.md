# Проект по автоматизации UI-тестов сайта okko.tv

> okko.tv - Российский стриминговый сервис, по состоянию на 2023 г. занимает четвертое место среди российских онлайн-кинотеатров по количеству подписчиков.

## Использованный стек технологий
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logos/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/logos/Java.svg">
<img width="6%" title="Docker" src="logos/Docker.svg">
<img width="6%" title="Selenide" src="media/logos/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logos/Selenoid.svg">
<img width="6%" title="Gradle" src="media/logos/Gradle.svg">
<img width="6%" title="JUnit5" src="media/logos/JUnit5.svg">
<img width="6%" title="GitHub" src="media/logos/GitHub.svg">
<img width="6%" title="Telegram" src="media/logos/Telegram.svg">
<img width="5%" title="Jira" src="media/logos/Jira.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide. 
- В качестве сборщика был использован - <code>Gradle</code>.  
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для "удаленного" запуска, локально был поднят docker с selenoid на wsl ubuntu


Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.


## Содержание:
- [Запуск автотестов](#arrow_forward-Запуск-автотестов)
- [Пример Allure-отчета](#-Пример-Allure-отчета)
- [Уведомления в Telegram с использованием бота](#-Уведомления-в-Telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-Selenoid)




## Запуск автотестов

### Возможнный запуск тестов из терминала
```
gradle clean web_test
gradle clean web_test -Denv=remote
```
Для удаленного запуска тестов <code>Selenoid</code>.
необходимо поменять remoteUrl на ваш, в ./src/test/resources/remote.properties

## <img src="media/logos/Allure_Report.svg" title="Allure Report" width="4%"/> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="media/screenshots/allure_overview.png">
</p>

### Тест-кейсы

<p align="center">
<img title="Test Results in Alure" src="media/screenshots/test_case1.png">
</p>

<p align="center">
<img title="Test Results in Alure" src="media/screenshots/test_case2.png">
</p>

### Графики

<p align="center">
<img title="Test Results in Alure" src="media/screenshots/allure_graphs.png">
</p>


## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logos/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения тестов бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screenshots/Telegram_dOO4Xyu1au.png">
</p>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screenshots/search_test_video_sample">
</p>

