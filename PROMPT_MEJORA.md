# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/resources/features/payment_flow.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/fintech/payment/steps/PaymentStepDefinitions.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/fintech/payment/integration/PaymentIntegrationTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/fintech/payment/unit/PaymentUseCaseTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/fintech/payment/domain/model/Payment.java` — `PaymentChannel.name`: Se invoca `name` sobre `PaymentChannel`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payment/infrastructure/controllers/PaymentController.java` — `LiquidationService.liquidatePayment`: Se invoca `liquidatePayment` sobre `LiquidationService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Chapter Backend, Especialidad Desarrollador, Tecnologia Java, Advanced - Aplica metodologias de desarrollo basadas en comportamiento como BDD (Desarrollo Guiado por Comportamiento) y trabaja bajo herramientas de automatizacion como Cucumber, el framework Karate, etc. - Candidato con experiencia avanzada en backend, trabajando en equipo distribuido, con solida base en arquitectura y testing.

### Reto
- Tema: Desarrollador con Solida Experiencia en BDD y Frameworks de Automatizacion
- Seniority: advanced-l2
- Tipo: mixed
- Título: Implementación de BDD en un Sistema de Gestión de Pagos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del Flujo de Pago — objetivo: Definir el flujo de pago utilizando BDD, identificando los pasos clave y los escenarios de prueba. — entregable (NO resolver): Escenarios de prueba definidos en Gherkin para el flujo de pago.
- Fase 2: Implementación del Flujo de Pago — objetivo: Implementar el flujo de pago definido en la fase anterior, asegurando la idempotencia y manejando los diferentes casos de éxito, rechazo y errores. — entregable (NO resolver): Flujo de pago implementado utilizando BDD, con escenarios de prueba ejecutados y validados.
- Fase 3: Evaluación y Optimización del Flujo de Pago — objetivo: Evaluar y optimizar el flujo de pago implementado, identificando posibles mejoras y trade-offs. — entregable (NO resolver): Reporte de evaluación y optimización del flujo de pago, con propuestas de mejora y justificación de decisiones.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.fintech</groupId>
    <artifactId>payment-system</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>payment-system</name>
    <description>Sistema de gestión de pagos con BDD y manejo de idempotencia</description>

    <properties>
        <java.version>21</java.version>
        <cucumber.version>7.18.0</cucumber.version>
        <resilience4j.version>2.2.0</resilience4j.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <!-- Resilience4j para manejo de fallos -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-spring</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>

        <!-- PostgreSQL -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
            <scope>runtime</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>21</source>
                    <target>21</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/fintech/payment/Application.java ===
package com.fintech.payment;



import com.fintech.payment.infrastructure.error.GlobalExceptionHandler;
import com.fintech.payment.infrastructure.config.IdempotencyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import java.time.Duration;

@SpringBootApplication
@EnableAsync
@Import({
    com.fintech.payment.infrastructure.config.IdempotencyConfig.class,
    com.fintech.payment.infrastructure.error.GlobalExceptionHandler.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CircuitBreakerConfig circuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .permittedNumberOfCallsInHalfOpenState(3)
                .slidingWindowSize(10)
                .recordExceptions(
                    java.io.IOException.class,
                    org.springframework.web.client.HttpServerErrorException.class,
                    org.springframework.web.client.ResourceAccessException.class
                )
                .build();
    }

    @Bean
    public TimeLimiterConfig timeLimiterConfig() {
        return TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofMillis(2000))
                .build();
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080
  servlet:
    context-path: /api/payments

spring:
  application:
    name: payment-system
  datasource:
    url: jdbc:postgresql://localhost:5432/payment_db
    username: payment_user
    password: payment_password
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 20
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        jdbc:
          lob:
            non_contextual_creation: true

resilience4j:
  circuitbreaker:
    instances:
      cardVerification:
        baseConfig: default
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
      liquidation:
        baseConfig: default
        registerHealthIndicator: true
  timelimiter:
    instances:
      cardVerification:
        timeoutDuration: 2s

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,circuitbreakers
  endpoint:
    health:
      show-details: always

external:
  card-verification:
    url: https://api.card-verification-service.com/verify
    timeout: 2000
    retry:
      maxAttempts: 3
      waitDuration: 500
  liquidation:
    url: http://localhost:8081/api/liquidation
    timeout: 3000

// === ARCHIVO: src/main/java/com/fintech/payment/domain/model/Payment.java ===
package com.fintech.payment.domain.model;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Payment(
    @NotNull(message = "El ID del pago no puede ser nulo")
    UUID paymentId,

    @NotNull(message = "El ID de la orden no puede ser nulo")
    @Size(min = 1, max = 64, message = "El ID de la orden debe tener entre 1 y 64 caracteres")
    String orderId,

    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
    BigDecimal amount,

    @NotNull(message = "La moneda no puede ser nula")
    @Size(min = 3, max = 3, message = "La moneda debe ser un código de 3 caracteres")
    String currency,

    @NotNull(message = "El número de tarjeta no puede ser nulo")
    @Size(min = 13, max = 19, message = "El número de tarjeta debe tener entre 13 y 19 dígitos")
    String cardNumber,

    @NotNull(message = "El titular de la tarjeta no puede ser nulo")
    @Size(min = 2, max = 255, message = "El titular de la tarjeta debe tener entre 2 y 255 caracteres")
    String cardHolder,

    @NotNull(message = "La fecha de expiración no puede ser nula")
    @Future(message = "La tarjeta debe estar vigente")
    LocalDateTime cardExpiry,

    @NotNull(message = "El CVV no puede ser nulo")
    @Size(min = 3, max = 4, message = "El CVV debe tener entre 3 y 4 dígitos")
    String cardCvv,

    @NotNull(message = "El canal de pago no puede ser nulo")
    PaymentChannel channel,

    @NotNull(message = "El estado del pago no puede ser nulo")
    PaymentStatus status,

    @NotNull(message = "La fecha de creación no puede ser nula")
    LocalDateTime createdAt,

    LocalDateTime processedAt,

    String idempotencyKey
) {
    public Payment {
        if (paymentId == null) {
            paymentId = UUID.randomUUID();
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (status == null) {
            status = PaymentStatus.PENDING;
        }
    }

    public Payment withStatus(PaymentStatus newStatus) {
        return new Payment(
            this.paymentId,
            this.orderId,
            this.amount,
            this.currency,
            this.cardNumber,
            this.cardHolder,
            this.cardExpiry,
            this.cardCvv,
            this.channel,
            newStatus,
            this.createdAt,
            LocalDateTime.now(),
            this.idempotencyKey
        );
    }

    public Payment withIdempotencyKey(String key) {
        return new Payment(
            this.paymentId,
            this.orderId,
            this.amount,
            this.currency,
            this.cardNumber,
            this.cardHolder,
            this.cardExpiry,
            this.cardCvv,
            this.channel,
            this.status,
            this.createdAt,
            this.processedAt,
            key
        );
    }

    public String generateIdempotencyKey() {
        return orderId + "_" + channel.name();
    }

    public enum PaymentChannel {
        MOBILE_APP, WEB, IN_STORE, CALL_CENTER
    }

    public enum PaymentStatus {
        PENDING, PROCESSING, COMPLETED, FAILED, REJECTED
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/domain/ports/PaymentRepository.java ===
package com.fintech.payment.domain.ports;

import com.fintech.payment.domain.model.Payment;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(UUID paymentId);
    Optional<Payment> findByIdempotencyKey(String idempotencyKey);
    Optional<Payment> findByOrderId(String orderId);
}

// === ARCHIVO: src/main/java/com/fintech/payment/domain/ports/CardVerificationService.java ===
package com.fintech.payment.domain.ports;

import com.fintech.payment.domain.model.Payment;

public interface CardVerificationService {
    CardVerificationResult verifyCard(Payment payment);

    enum CardVerificationResult {
        APPROVED,
        REJECTED,
        ERROR
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/domain/ports/LiquidationService.java ===
package com.fintech.payment.domain.ports;

import com.fintech.payment.domain.model.Payment;

public interface LiquidationService {
    Payment processLiquidation(Payment payment);
}

// === ARCHIVO: src/main/java/com/fintech/payment/infrastructure/adapters/PaymentJpaRepository.java ===
package com.fintech.payment.infrastructure.adapters;

import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment, UUID>, PaymentRepository {
    Optional<Payment> findByIdempotencyKey(String idempotencyKey);
    Optional<Payment> findByOrderId(String orderId);
}

// === ARCHIVO: src/main/java/com/fintech/payment/domain/exceptions/CardVerificationException.java ===
package com.fintech.payment.domain.exceptions;

public class CardVerificationException extends RuntimeException {
    private final String cardNumber;
    private final String errorMessage;

    public CardVerificationException(String cardNumber, String errorMessage) {
        super(errorMessage);
        this.cardNumber = cardNumber;
        this.errorMessage = errorMessage;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "CardVerificationException{cardNumber='" + cardNumber + "', errorMessage='" + errorMessage + "'}";
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/domain/exceptions/LiquidationException.java ===
package com.fintech.payment.domain.exceptions;

import jakarta.validation.ValidationException;

public class LiquidationException extends ValidationException {
    public LiquidationException(String message) {
        super(message);
    }
    public LiquidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/domain/exceptions/IdempotencyException.java ===
package com.fintech.payment.domain.exceptions;

public class IdempotencyException extends RuntimeException {
    public IdempotencyException(String message) {
        super(message);
    }
    public IdempotencyException(String message, Throwable cause) {
        super(message, cause);
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/application/usecases/PaymentUseCase.java ===
package com.fintech.payment.application.usecases;



import com.fintech.payment.domain.model.PaymentStatus;
import com.fintech.payment.domain.ports.CardVerificationResult;
import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.CardVerificationService;
import com.fintech.payment.domain.ports.PaymentRepository;
import com.fintech.payment.domain.exceptions.LiquidationException;
import com.fintech.payment.domain.exceptions.IdempotencyException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final CardVerificationService cardVerificationService;

    @Autowired
    public PaymentUseCase(PaymentRepository paymentRepository, CardVerificationService cardVerificationService) {
        this.paymentRepository = paymentRepository;
        this.cardVerificationService = cardVerificationService;
    }

    @Transactional
    public Payment processPayment(@Valid @NotNull Payment payment) {
        String idempotencyKey = payment.generateIdempotencyKey();
        Optional<Payment> existingPayment = paymentRepository.findByIdempotencyKey(idempotencyKey);

        if (existingPayment.isPresent()) {
            throw new IdempotencyException("Payment with idempotency key already exists");
        }

        CardVerificationService.CardVerificationResult verificationResult = cardVerificationService.verifyCard(payment);
        if (verificationResult == CardVerificationService.CardVerificationResult.REJECTED) {
            throw new LiquidationException("Card verification failed");
        }

        payment = payment.withStatus(Payment.PaymentStatus.PROCESSING);
        payment = paymentRepository.save(payment);
        // Simulate external service call for payment liquidation
        if (Math.random() < 0.1) {
            throw new LiquidationException("External service error during liquidation");
        }
        payment = payment.withStatus(Payment.PaymentStatus.COMPLETED);
        return paymentRepository.save(payment);
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/infrastructure/adapters/CardVerificationClient.java ===
package com.fintech.payment.infrastructure.adapters;

import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.CardVerificationService;
import com.fintech.payment.domain.ports.CardVerificationResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardVerificationClient implements CardVerificationService {

    private final RestTemplate restTemplate;
    private final String verificationUrl;

    public CardVerificationClient(RestTemplate restTemplate, @Value("${external.services.card-verification.url}") String verificationUrl) {
        this.restTemplate = restTemplate;
        this.verificationUrl = verificationUrl;
    }

    @Override
    public CardVerificationResult verifyCard(Payment payment) {
        try {
            // Simulate a call to an external service for card verification
            // In a real scenario, this would involve making an actual HTTP request to the external service
            // For the purpose of this example, we'll return a hardcoded result
            return CardVerificationResult.APPROVED;
        } catch (Exception e) {
            // Handle any exceptions that occur during the verification process
            throw new RuntimeException("Card verification failed", e);
        }
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/infrastructure/adapters/LiquidationServiceImpl.java ===
package com.fintech.payment.infrastructure.adapters;

import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.LiquidationService;
import org.springframework.stereotype.Service;

@Service
public class LiquidationServiceImpl implements LiquidationService {

    @Override
    public void liquidatePayment(Payment payment) {
        // Implement the logic for liquidating the payment
        // This could involve updating the payment status, interacting with external systems, etc.
        // For the purpose of this example, we'll just log the liquidation
        System.out.println("Liquidating payment: " + payment);
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/infrastructure/controllers/PaymentController.java ===
package com.fintech.payment.infrastructure.controllers;


import com.fintech.payment.domain.ports.CardVerificationResult;
import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.PaymentRepository;
import com.fintech.payment.domain.ports.CardVerificationService;
import com.fintech.payment.domain.ports.LiquidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;
    private final CardVerificationService cardVerificationService;
    private final LiquidationService liquidationService;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository, CardVerificationService cardVerificationService, LiquidationService liquidationService) {
        this.paymentRepository = paymentRepository;
        this.cardVerificationService = cardVerificationService;
        this.liquidationService = liquidationService;
    }

    @PostMapping
    public ResponseEntity<Payment> initiatePayment(@RequestBody Payment payment) {
        // Verify the card
        CardVerificationResult result = cardVerificationService.verifyCard(payment);
        if (result!= CardVerificationResult.APPROVED) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(null);
        }

        // Save the payment
        Payment savedPayment = paymentRepository.save(payment);

        // Liquidate the payment
        liquidationService.liquidatePayment(savedPayment);

        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable UUID id) {
        return paymentRepository.findById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/infrastructure/config/IdempotencyConfig.java ===
package com.fintech.payment.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class IdempotencyConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}

// === ARCHIVO: src/main/java/com/fintech/payment/infrastructure/error/GlobalExceptionHandler.java ===
package com.fintech.payment.infrastructure.error;

import com.fintech.payment.domain.exceptions.CardVerificationException;
import com.fintech.payment.domain.exceptions.IdempotencyException;
import com.fintech.payment.domain.exceptions.LiquidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CardVerificationException.class)
    public ResponseEntity<String> handleCardVerificationException(CardVerificationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(IdempotencyException.class)
    public ResponseEntity<String> handleIdempotencyException(IdempotencyException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(LiquidationException.class)
    public ResponseEntity<String> handleLiquidationException(LiquidationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}

// === ARCHIVO: src/test/resources/features/payment_flow.feature ===
Feature: Payment Flow

  Scenario: Successful payment
    Given a valid payment request
    When the payment is processed
    Then the payment should be successful

  Scenario: Payment rejection
    Given an invalid payment request
    When the payment is processed
    Then the payment should be rejected

  Scenario: Temporary error
    Given a valid payment request
    When the payment service is temporarily unavailable
    Then the payment should be retried

// === ARCHIVO: src/test/java/com/fintech/payment/steps/PaymentStepDefinitions.java ===
package com.fintech.payment.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.PaymentRepository;

public class PaymentStepDefinitions {

    @Autowired
    private PaymentRepository paymentRepository;

    private Payment payment;

    @Given("a valid payment request")
    public void a_valid_payment_request() {
        // Stub
    }

    @When("the payment is processed")
    public void the_payment_is_processed() {
        // Stub
    }

    @Then("the payment should be successful")
    public void the_payment_should_be_successful() {
        // Stub
    }

    @Given("an invalid payment request")
    public void an_invalid_payment_request() {
        // Stub
    }

    @Then("the payment should be rejected")
    public void the_payment_should_be_rejected() {
        // Stub
    }

    @Given("a valid payment request")
    public void a_valid_payment_request_temporary_error() {
        // Stub
    }

    @When("the payment service is temporarily unavailable")
    public void the_payment_service_is_temporarily_unavailable() {
        // Stub
    }

    @Then("the payment should be retried")
    public void the_payment_should_be_retried() {
        // Stub
    }
}

// === ARCHIVO: src/test/java/com/fintech/payment/integration/PaymentIntegrationTest.java ===
package com.fintech.payment.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fintech.payment.domain.ports.PaymentRepository;

@SpringBootTest
public class PaymentIntegrationTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @MockBean
    private PaymentRepository mockPaymentRepository;

    @Test
    public void testSuccessfulPayment() {
        // Stub
    }

    @Test
    public void testPaymentRejection() {
        // Stub
    }

    @Test
    public void testTemporaryError() {
        // Stub
    }
}

// === ARCHIVO: src/test/java/com/fintech/payment/unit/PaymentUseCaseTest.java ===
package com.fintech.payment.unit;




import com.fintech.payment.domain.exceptions.IdempotencyException;
import com.fintech.payment.domain.ports.CardVerificationResult;
import com.fintech.payment.domain.model.PaymentStatus;
import com.fintech.payment.application.usecases.PaymentUseCase;
import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.CardVerificationService;
import com.fintech.payment.domain.ports.PaymentRepository;
import com.fintech.payment.domain.exceptions.CardVerificationException;
import com.fintech.payment.domain.exceptions.LiquidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PaymentUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CardVerificationService cardVerificationService;

    @InjectMocks
    private PaymentUseCase paymentUseCase;

    private Payment payment;

    @BeforeEach
    public void setUp() {
        payment = new Payment(UUID.randomUUID(), "1234567890123456", 100, Payment.PaymentStatus.PENDING);
    }

    @Test
    public void testProcessPaymentSuccess() {
        when(cardVerificationService.verifyCard(payment)).thenReturn(CardVerificationService.CardVerificationResult.APPROVED);
        when(paymentRepository.save(payment)).thenReturn(payment);
        paymentUseCase.processPayment(payment);
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    public void testProcessPaymentCardVerificationFailure() {
        when(cardVerificationService.verifyCard(payment)).thenReturn(CardVerificationService.CardVerificationResult.DECLINED);
        assertThrows(CardVerificationException.class, () -> paymentUseCase.processPayment(payment));
    }

    @Test
    public void testProcessPaymentLiquidationFailure() {
        when(cardVerificationService.verifyCard(payment)).thenReturn(CardVerificationService.CardVerificationResult.APPROVED);
        when(paymentRepository.save(payment)).thenThrow(new LiquidationException("Liquidation failed"));
        assertThrows(LiquidationException.class, () -> paymentUseCase.processPayment(payment));
    }

    @Test
    public void testProcessPaymentIdempotency() {
        String idempotencyKey = "idempotency-key";
        payment.withIdempotencyKey(idempotencyKey);
        when(paymentRepository.findByIdempotencyKey(idempotencyKey)).thenReturn(Optional.of(payment));
        assertThrows(IdempotencyException.class, () -> paymentUseCase.processPayment(payment));
    }
}
```
