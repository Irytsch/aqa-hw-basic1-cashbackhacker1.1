# Домашнее задание к занятию «1.1. Основы автоматизации»

В качестве результата пришлите ссылку на ваш GitHub-проект в личном кабинете студента на сайте [netology.ru](https://netology.ru).

Все задачи этого занятия нужно делать **в одном репозитории**.

**Важно**: если у вас что-то не получилось, то оформляйте Issue [по установленным правилам](../report-requirements.md).

## Как сдавать задачи

1. Инициализируйте на своём компьютере пустой Git-репозиторий.
1. Добавьте в него готовый файл [.gitignore](../.gitignore).
1. Добавьте в этот же каталог код вашего приложения.
1. Сделайте необходимые коммиты.
1. Создайте публичный репозиторий на GitHub и свяжите свой локальный репозиторий с удалённым. Не забудьте настроить CI на ветках или PR.
1. Сделайте пуш — удостоверьтесь, что ваш код появился на GitHub.
1. Если ваши тесты нашли баг — создайте баг-репорт в GitHub Issue.
1. Ссылку на ваш проект отправьте в личном кабинете на сайте [netology.ru](https://netology.ru).
1. Задачи, отмеченные как необязательные, можно не сдавать, это не повлияет на получение зачёта.


## Задача №2: JUnit5 и legacy (необязательно)

## Легенда

Автотесты — это тоже код, и он подвержен тем же проблемам, что и обычный код.

Довольно часто встречается ситуация, когда в вашем проекте большое наследие (legacy) кода автотестов, например, на JUnit4.

Но новые тесты хочется писать, используя JUnit5. Что же делать в этом случае?

## Описание

JUnit5 представляет из себя комплексный проект, состоящий из трёх частей: JUnit Platform + JUnit Jupiter + JUnit Vintage.

![](pic/architecture.png) 

До этого мы достаточно вольно использовали названия JUnit5 и JUnit Jupiter, фактически как синонимы, но начиная с этого ДЗ, мы должны их различать.

- JUnit Platform отвечает за запуск тестовых фреймворков на JVM и определяет интерфейс [`TestEngine`](https://junit.org/junit5/docs/current/api/org.junit.platform.engine/org/junit/platform/engine/TestEngine.html). Это интерфейс, определяющий движок для поиска и запуска тестов. 
- JUnit Jupiter определяет API и реализацию `TestEngine` для запуска тестов, использующих данное API, junit-jupiter-engine — уже готовая реализация `JupiterTestEngine`.
- JUnit Vintage предоставляет `TestEngine` для запуска тестов, использующих JUnit4 и JUnit3.

#### Что нужно сделать

Из ветки junit4 создайте ветку junit4-platform, в которой:

1\. Добавьте в зависимости JUnit Vintage:
```groovy
dependencies {
    testImplementation 'junit:junit:4.13'
    testRuntimeOnly 'org.junit.vintage:junit-vintage-engine:5.6.2'
}
test {
    useJUnitPlatform()
}
```

2\. Удостоверьтесь, что ваши тесты запускаются.

3\. Добавьте в зависимости JUnit Jupiter (по факту — замените код из п.1):
```groovy
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.6.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.6.1'
    testImplementation 'junit:junit:4.13'
    testRuntimeOnly 'org.junit.vintage:junit-vintage-engine:5.6.2'
}
test {
    useJUnitPlatform()
}
```

4\. Напишите те же тесты, но с использованием API JUnit Jupiter.

5\. Удостоверьтесь, что запускаются и тесты JUnit4, и тесты JUnit Jupiter.

6\. Соберите отчёты и запакуйте их в zip-архив. Напоминаем, они должны выглядеть примерно так:

![](pic/report.png)

7\. Создайте в проекте issue, к которому приложите отчёты. В личном кабинете вам нужно будет отправить ссылку на тот issue, что вы создали для демонстрационного проекта: https://github.com/netology-code/aqa-hw-sample/issues/1.