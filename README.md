# Implementación de BDD en un Sistema de Gestión de Pagos

En el contexto de un sistema de gestión de pagos para una fintech, se requiere implementar y validar un flujo de pago utilizando BDD. El sistema interactúa con un servicio externo que verifica la validez de la tarjeta y un servicio interno que gestiona la liquidación del pago. El flujo debe manejar casos de éxito, rechazo y errores temporales del servicio externo. Los pagos deben ser idempotentes con una clave basada en el número de operación y el canal de pago. Se espera que el sistema maneje un volumen de 1 500 solicitudes por segundo en hora pico.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Desarrollador con Solida Experiencia en BDD y Frameworks de Automatizacion |
| **Nivel** | advanced-l2 |
| **Tipo** | mixed |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición del Flujo de Pago

**Objetivo:** Definir el flujo de pago utilizando BDD, identificando los pasos clave y los escenarios de prueba.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los actores involucrados en el flujo de pago (originador de créditos, motor antifraude, buró de riesgos, core bancario, gateway de pagos, sistema de liquidación).
- Definir los criterios de aceptación para cada paso del flujo de pago.
- Crear escenarios de prueba que cubran casos de éxito, rechazo y errores temporales del servicio externo.

**Entregable:** Escenarios de prueba definidos en Gherkin para el flujo de pago.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo describirías el flujo de pago a un no técnico.
- Considera los diferentes estados que puede tener una solicitud de pago y cómo transita entre ellos.

</details>

### Fase 2: Implementación del Flujo de Pago

**Objetivo:** Implementar el flujo de pago definido en la fase anterior, asegurando la idempotencia y manejando los diferentes casos de éxito, rechazo y errores.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Implementar la lógica del flujo de pago utilizando BDD.
- Asegurar que los pagos sean idempotentes con una clave basada en el número de operación y el canal de pago.
- Manejar los diferentes casos de éxito, rechazo y errores temporales del servicio externo.

**Entregable:** Flujo de pago implementado utilizando BDD, con escenarios de prueba ejecutados y validados.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo asegurar la idempotencia en el flujo de pago.
- Considera los diferentes modos de falla del servicio externo y cómo manejarlos.

</details>

### Fase 3: Evaluación y Optimización del Flujo de Pago

**Objetivo:** Evaluar y optimizar el flujo de pago implementado, identificando posibles mejoras y trade-offs.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Evaluar el flujo de pago implementado, identificando posibles mejoras y trade-offs.
- Considerar la escalabilidad y la robustez del sistema ante un volumen de 1 500 solicitudes por segundo en hora pico.
- Proponer mejoras y justificar las decisiones tomadas.

**Entregable:** Reporte de evaluación y optimización del flujo de pago, con propuestas de mejora y justificación de decisiones.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo escalar el sistema para manejar un volumen alto de solicitudes.
- Considera los trade-offs entre consistencia y disponibilidad en el flujo de pago.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es BDD y cómo se aplica en el flujo de pago?
- **paraQueSirve**: ¿Para qué sirve el flujo de pago definido y cómo beneficia al sistema?
- **comoSeUsa**: ¿Cómo se usa BDD para implementar y validar el flujo de pago?
- **erroresComunes**: ¿Cuáles son los errores comunes en la implementación del flujo de pago y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la evaluación y optimización del flujo de pago?

## Criterios de Evaluacion

- Definición clara del flujo de pago utilizando BDD.
- Implementación del flujo de pago con idempotencia y manejo de errores.
- Evaluación y propuestas de mejora del flujo de pago con justificación de decisiones.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
